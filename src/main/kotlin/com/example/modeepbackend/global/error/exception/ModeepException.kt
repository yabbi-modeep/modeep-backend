package com.example.modeepbackend.global.error.exception

abstract class ModeepException(
        private val errorCode: ErrorCode,
) : RuntimeException() {
    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message
}
