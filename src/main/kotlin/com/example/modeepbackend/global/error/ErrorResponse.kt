package com.example.modeepbackend.global.error

import com.example.modeepbackend.global.error.exception.ModeepException

class ErrorResponse(
        val status: Int,
        val message: String
) {
    companion object {
        fun of(e: ModeepException): ErrorResponse {
            return ErrorResponse(e.status, e.message)
        }
    }
}
