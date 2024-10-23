package com.example.modeepbackend.global.exception

import com.example.modeepbackend.global.error.exception.ErrorCode
import com.example.modeepbackend.global.error.exception.ModeepException

object InternalServerError : ModeepException(ErrorCode.INTERNAL_SERVER_ERROR) {
}