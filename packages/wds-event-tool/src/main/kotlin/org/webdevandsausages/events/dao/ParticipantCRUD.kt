package org.webdevandsausages.events.dao

import arrow.core.Option
import arrow.core.Try
import arrow.core.getOrDefault
import arrow.core.toOption
import meta.tables.daos.EventDao
import meta.tables.Participant
import meta.tables.records.ParticipantRecord
import org.jooq.impl.DSL
import org.webdevandsausages.events.config.local
import org.webdevandsausages.events.dto.ParticipantDto
import org.webdevandsausages.events.dto.RegistrationInDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ParticipantCRUD : EventDao(local.jooqConfiguration) {

    fun db() = DSL.using(configuration())

    val ParticipantRecord.fullName: String get() = "${firstName ?: "-"} ${lastName ?: ""}".trim()

    fun create(registration: RegistrationInDto): Option<ParticipantDto> {
        val (eventId, firstName, lastName, affiliation, email, verificationToken, orderNumber, status) = registration
        return with(Participant.PARTICIPANT) {
            db().use { ctx ->
                ctx
                    .insertInto(Participant.PARTICIPANT,
                        FIRST_NAME,
                        LAST_NAME,
                        EMAIL,
                        AFFILIATION,
                        VERIFICATION_TOKEN,
                        ORDER_NUMBER,
                        EVENT_ID,
                        STATUS
                        )
                    .values(
                        firstName,
                        lastName,
                        email,
                        affiliation,
                        verificationToken,
                        orderNumber,
                        eventId,
                        status
                        )
                    .returning(FIRST_NAME, LAST_NAME, EMAIL, VERIFICATION_TOKEN, STATUS, ORDER_NUMBER)
                    .fetchOne()
            }.let {
                println(it)
                ParticipantDto(
                    email = it.email,
                    name = it.fullName,
                    verificationToken = it.verificationToken,
                    affiliation = it.affiliation,
                    status = it.status,
                    orderNumber = it.orderNumber,
                    insertedOn = LocalDate.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    ).toOption()
            }
        }
    }

    fun findByToken(token: String): Option<ParticipantDto> {
        return Try {
            with(Participant.PARTICIPANT) {
                db().use { ctx ->
                    ctx
                        .selectFrom(this)
                        .where(this.VERIFICATION_TOKEN.eq(token))
                        .fetchOne()
                }?.let {
                    ParticipantDto(
                        email = it.email,
                        name = it.fullName,
                        verificationToken = it.verificationToken,
                        status = it.status,
                        orderNumber = it.orderNumber / 1000,
                        affiliation = it.affiliation
                        )
                }
            }
        }.getOrDefault { null }.toOption()
    }
}