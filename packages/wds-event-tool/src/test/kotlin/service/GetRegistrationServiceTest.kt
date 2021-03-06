package service

import arrow.core.Right
import arrow.core.Some
import io.kotlintest.Description
import io.kotlintest.assertSoftly
import io.kotlintest.assertions.arrow.either.beRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.slot
import meta.enums.EventStatus
import meta.enums.ParticipantStatus
import meta.tables.pojos.Event
import meta.tables.pojos.Participant
import org.jooq.Configuration
import org.jooq.impl.DSL
import org.webdevandsausages.events.dto.EventDto
import org.webdevandsausages.events.dto.ParticipantDto
import org.webdevandsausages.events.service.registration.GetRegistrationService
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.OffsetDateTime

class GetRegistrationServiceTest : StringSpec() {
    lateinit var unit: GetRegistrationService

    private var participantList = mutableListOf<Participant>()

    private val TIMESTAMP = Timestamp.valueOf(LocalDateTime.now().minusDays(4))

    private var dbEvent = EventDto(
        event = Event(
            1,
            "Vol 10",
            "Acme",
            "Joe",
            OffsetDateTime.now().plusDays(4),
            "Great presentations",
            "Tampere center",
            EventStatus.OPEN,
            10,
            Timestamp.valueOf(LocalDateTime.now().plusDays(2)),
            TIMESTAMP,
            TIMESTAMP,
            10,
            "www.acme.fi"
        ),
        participants = populateParticipants()
    )

    private fun populateParticipants(): MutableList<Participant> {
        for (n in 1..14) {
            val status = if (n < 9) ParticipantStatus.REGISTERED else ParticipantStatus.WAIT_LISTED
            participantList.add(
                Participant(
                    1,
                    "first_$n",
                    "last_$n",
                    "first_${n}last_$n@mail.com",
                    "Acme",
                    "token_$n",
                    n * 1000,
                    1,
                    status,
                    TIMESTAMP,
                    TIMESTAMP
                )
            )
        }
        return participantList
    }

    override fun beforeTest(description: Description) {
        unit = GetRegistrationService(
            eventCRUD = mockk(relaxed = true),
            participantCRUD = mockk(relaxed = true)
        )
        every { unit.eventCRUD.db } returns DSL.using(mockkClass(Configuration::class, relaxed = true))
        every { unit.participantCRUD.db } returns DSL.using(mockkClass(Configuration::class, relaxed = true))
    }

    init {
        "happy case get registration by event id and participant token" {
            val slot = slot<String>()
            every { unit.eventCRUD.findByIdOrLatest(any()) } returns Some(dbEvent)
            every { unit.participantCRUD.findByToken(capture(slot)) } returns Some(
                ParticipantDto(
                    email = "first_7last_7@mail.com",
                    name = "first_7 last_7",
                    verificationToken = "token_7",
                    status = ParticipantStatus.REGISTERED,
                    orderNumber = 7000
                )
            )

            val resultingEither = unit(1, "token_7")
            assertSoftly {
                resultingEither.isRight().shouldBe(true)
                beRight(
                    resultingEither.shouldBe(
                        Right(
                            ParticipantDto(
                                email = "first_7last_7@mail.com",
                                name = "first_7 last_7",
                                verificationToken = "token_7",
                                status = ParticipantStatus.REGISTERED,
                                orderNumber = 7
                            )
                        )
                    )
                )
                slot.captured.shouldBe("token_7")
            }
        }

        "should return order number in own status group" {
            val slot = slot<String>()
            every { unit.eventCRUD.findByIdOrLatest(any()) } returns Some(dbEvent)
            every { unit.participantCRUD.findByToken(capture(slot)) } returns Some(
                ParticipantDto(
                    email = "first_11last_11@mail.com",
                    name = "first_11 last_11",
                    verificationToken = "token_11",
                    status = ParticipantStatus.WAIT_LISTED,
                    orderNumber = 11000
                )
            )

            val resultingEither = unit(1, "token_11")
            assertSoftly {
                resultingEither.isRight().shouldBe(true)
                beRight(
                    resultingEither.shouldBe(
                        Right(
                            ParticipantDto(
                                email = "first_11last_11@mail.com",
                                name = "first_11 last_11",
                                verificationToken = "token_11",
                                status = ParticipantStatus.WAIT_LISTED,
                                orderNumber = 3
                            )
                        )
                    )
                )
                slot.captured.shouldBe("token_11")
            }
        }
    }
}
