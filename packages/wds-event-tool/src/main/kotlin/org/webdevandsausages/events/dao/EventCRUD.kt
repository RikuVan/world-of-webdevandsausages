package org.webdevandsausages.events.dao

import meta.enums.EventStatus
import meta.tables.Event
import meta.tables.Participant
import meta.tables.daos.EventDao
import meta.tables.records.EventRecord
import org.jooq.Condition
import org.jooq.TableField
import org.jooq.impl.DSL
import org.simpleflatmapper.jdbc.JdbcMapperFactory
import org.simpleflatmapper.util.TypeReference
import org.webdevandsausages.events.config.local
import org.webdevandsausages.events.dto.EventDto
import kotlin.streams.toList

typealias EventUpdates= List<Pair<TableField<EventRecord, Any>, Any>>

object EventCRUD: EventDao(local.jooqConfiguration) {

    val db = DSL.using(configuration())
    val mapperInstance = JdbcMapperFactory.newInstance()

    /**
     * Custom method with custom query + mapper
     */
    fun findAllWithParticipants(status: String?): List<EventDto>? {
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

        return jdbcMapper.stream(resultSet).map { EventDto(it.first, it.second) }.toList()
    }

    private fun hasStatus(value: EventStatus): Condition = Event.EVENT.STATUS.eq(value)

    fun findByIdOrLatest(id: Long? = null): EventDto? {
        val resultSet = db.use { ctx ->
            ctx.select()
                .from(Event.EVENT)
                .leftJoin(Participant.PARTICIPANT)
                .on(Event.EVENT.ID.eq(Participant.PARTICIPANT.EVENT_ID))
                .apply {
                    when(id) {
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
            .newMapper(object : TypeReference<Pair<meta.tables.pojos.Event, List<meta.tables.pojos.Participant>>>() {})

        return jdbcMapper.stream(resultSet).map { EventDto(it.first, it.second) }.toList().firstOrNull()
    }

    // can handle an arbitrary number of updates
    fun update(id: Long?, updates: EventUpdates) {
        return db.use { ctx ->
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
    }
}