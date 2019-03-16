package org.webdevandsausages.events.dao

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.Try
import arrow.core.getOrDefault
import arrow.core.toOption
import meta.enums.EventStatus
import meta.tables.Event
import meta.tables.Participant
import meta.tables.daos.EventDao
import meta.tables.records.EventRecord
import org.jooq.Condition
import org.jooq.Configuration
import org.jooq.TableField
import org.jooq.impl.DSL
import org.simpleflatmapper.jdbc.JdbcMapperFactory
import org.simpleflatmapper.util.TypeReference
import org.webdevandsausages.events.dto.EventDto
import org.webdevandsausages.events.dto.EventInDto
import kotlin.streams.toList

typealias EventUpdates = List<Pair<TableField<EventRecord, Any>, Any>>

class EventCRUD(configuration: Configuration) : EventDao(configuration) {
    val db = DSL.using(configuration())
    val mapperInstance = JdbcMapperFactory.newInstance()

    fun findAllWithParticipants(status: String?): List<EventDto> {
        val resultSet = db.use { ctx ->
            ctx.select()
                .from(Event.EVENT)
                .leftJoin(Participant.PARTICIPANT)
                .on(Event.EVENT.ID.eq(Participant.PARTICIPANT.EVENT_ID))
                .apply {
                    if (status != null)
                        where(hasStatus(EventStatus.valueOf(status.toUpperCase())))
                }
                .orderBy(Event.EVENT.ID) // This is a crucial step to prevent simpleflatmapper creating duplicates // Check: https://www.petrikainulainen.net/programming/jooq/jooq-tips-implementing-a-read-only-one-to-many-relationship/
                .fetchResultSet()
        }

        val jdbcMapper = mapperInstance
            .addKeys(Event.EVENT.ID.name, Participant.PARTICIPANT.ID.name)
            .newMapper(object : TypeReference<Pair<meta.tables.pojos.Event, List<meta.tables.pojos.Participant>>>() {})

        return Try {
            jdbcMapper.stream(resultSet).map { EventDto(it.first, it.second) }.toList()
        }.getOrDefault { emptyList() }
    }

    private fun hasStatus(value: EventStatus): Condition = Event.EVENT.STATUS.eq(value)

    fun findByIdOrLatest(id: Long? = null): Option<EventDto> {
        return Try {
            val resultSet = db.use { ctx ->
                ctx.select()
                    .from(Event.EVENT)
                    .leftJoin(Participant.PARTICIPANT)
                    .on(Event.EVENT.ID.eq(Participant.PARTICIPANT.EVENT_ID))
                    .apply {
                        when (id) {
                            is Long -> where(Event.EVENT.ID.eq(id))
                            else -> where(hasStatus(EventStatus.OPEN))
                                .or(hasStatus(EventStatus.VISIBLE))
                                .or(hasStatus(EventStatus.OPEN_WITH_WAITLIST))
                                .or(hasStatus(EventStatus.OPEN_FULL))
                                .or(hasStatus(EventStatus.CLOSED_WITH_FEEDBACK))
                        }
                    }
                    .fetchResultSet()
            }
            val jdbcMapper = mapperInstance
                .addKeys(Event.EVENT.ID.name, Participant.PARTICIPANT.ID.name)
                .newMapper(object :
                    TypeReference<Pair<meta.tables.pojos.Event, List<meta.tables.pojos.Participant>>>() {})

            jdbcMapper.stream(resultSet).peek {
            } .map { EventDto(it.first, it.second) }.toList().firstOrNull()
        }.getOrDefault { null }.toOption()
    }

    // can handle an arbitrary number of updates
    fun update(id: Long?, updates: EventUpdates): Option<Int> {
        val result = Try {
            db.use { ctx ->
                ctx
                    .update(Event.EVENT)
                    .set(updates[0].first, updates[0].second)
                    .apply {
                        updates.drop(1).forEach {
                            set(it.first, it.second)
                        }
                    }
                    .where(Event.EVENT.ID.eq(id))
                    .execute()
            }
        }.getOrDefault { 0 }
        return if (result == 1) Some(1) else None
    }

    fun findByParticipantToken(registrationToken: String): Option<EventDto> = db.use { ctx ->
        val event = Try {
            ctx.select(*Event.EVENT.fields())
                .from(Event.EVENT)
                .leftJoin(Participant.PARTICIPANT)
                .on(Event.EVENT.ID.eq(Participant.PARTICIPANT.EVENT_ID))
                .where(Participant.PARTICIPANT.VERIFICATION_TOKEN.eq(registrationToken))
                .fetchAny()
                .into(meta.tables.pojos.Event::class.java)
        }.toOption()
        when (event) {
            is Some ->findByIdOrLatest(event.t.id)
            is None -> event
        }
    }

    fun create(event: EventInDto): Option<EventDto> {
        return with(Event.EVENT) {
            val (name,
                contact,
                sponsor,
                date,
                details,
                location,
                status,
                maxParticipants,
                registrationOpens,
                volume,
                sponsorLnk
               ) = event
            db.use { ctx ->
                ctx
                    .insertInto(
                        Event.EVENT,
                        NAME,
                        SPONSOR,
                        CONTACT,
                        DATE,
                        DETAILS,
                        LOCATION,
                        STATUS,
                        MAX_PARTICIPANTS,
                        REGISTRATION_OPENS,
                        VOLUME,
                        SPONSOR_LINK
                    )
                    .values(
                        name,
                        contact,
                        sponsor,
                        date,
                        details,
                        location,
                        status,
                        maxParticipants,
                        registrationOpens,
                        volume,
                        sponsorLnk
                    )
                    .returning()
                    .fetchOne()
            }.let {
                EventDto(
                    event = meta.tables.pojos.Event(
                        it.id,
                        it.name,
                        it.sponsor,
                        it.contact,
                        it.date,
                        it.details,
                        it.location,
                        it.status,
                        it.maxParticipants,
                        it.registrationOpens,
                        it.createdOn,
                        it.updatedOn,
                        it.volume,
                        it.sponsorLink
                    )
                ).toOption()
            }
        }
    }

}

val EventCRUD.field get() = Event.EVENT
