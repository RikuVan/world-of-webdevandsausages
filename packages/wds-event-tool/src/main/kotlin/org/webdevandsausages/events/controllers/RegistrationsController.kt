package org.webdevandsausages.events.controllers

import org.slf4j.Logger
import org.webdevandsausages.events.dto.EventDto
import org.webdevandsausages.events.dto.ParticipantDto
import org.webdevandsausages.events.dto.RegistrationInDto
import org.webdevandsausages.events.services.EmailService
import org.webdevandsausages.events.services.EventService
import org.webdevandsausages.events.services.RandomTokenService
import org.webdevandsausages.events.services.RegistrationService
import org.webdevandsausages.events.services.isOpenRegistrationStatus
import org.webdevandsausages.events.utils.prettified

interface CreateRegistrationController {
    operator fun invoke(registration: RegistrationInDto): ParticipantDto?
}

class CreateRegistrationControllerImpl(
    val eventService: EventService,
    val registrationService: RegistrationService,
    val randomTokenService: RandomTokenService,
    val emailService: EmailService,
    val logger: Logger
  ) : CreateRegistrationController {
    override fun invoke(registration: RegistrationInDto): ParticipantDto? {
        // TODO: handle error cases
        val eventData: EventDto? = eventService.getByIdOrLatest(registration.eventId)
        if (eventData == null || !eventData.event.status.isOpenRegistrationStatus) {
            println("handle invalid or nonexistent event")
        } else if (eventData.participants.find { it.email == registration.email} != null) {
            println("handle already registered")
        }
        val token = getVerificationToken()
        val lastNumber = eventData?.participants?.maxBy { it.orderNumber }?.orderNumber ?: 0
        val registrationWithToken = registration.copy(registrationToken = token, orderNumber = lastNumber + 1000)
        val result = registrationService.create(registrationWithToken)

        if (result != null && eventData != null) {
            val sponsor = if (eventData.event.sponsor != null) eventData.event.sponsor else "Anonymous"
            val emailData = mapOf(
                "action" to "registered",
                "datetime" to eventData.event.date.prettified,
                "location" to eventData.event.location,
                "token" to result.verificationToken,
                "sponsor" to sponsor
            )

            emailService.sendMail(
                result.email,
                result.name,
                "Web Dev & Sausages Registration",
                "d-91e5bf696190444d94f13e564fee4426",
                emailData
            )
        }
        return result
    }

    fun getVerificationToken(): String {
        var token: String?
        do {
            token = randomTokenService.getWordPair()
        } while(token !is String || registrationService.getByToken(token) != null)
        return token
    }
}