package com.example.modeepbackend.global.exception

import com.example.modeepbackend.global.error.exception.ErrorCode
import com.example.modeepbackend.global.error.exception.ModeepException

object TokenExpiredException : ModeepException(ErrorCode.TOKEN_EXPIRED) {
}