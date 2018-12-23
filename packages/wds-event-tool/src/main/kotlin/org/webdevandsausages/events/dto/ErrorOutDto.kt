package org.webdevandsausages.events.dto

enum class ErrorCode {
    NOT_FOUND,
    EVENT_CLOSED_OR_MISSING,
    ALREADY_REGISTERED,
    DATABASE_ERROR
}

data class ErrorOutDto(val message: String, val code: ErrorCode)