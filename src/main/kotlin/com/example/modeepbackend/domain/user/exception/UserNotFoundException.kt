package com.example.modeepbackend.domain.user.exception

import com.example.modeepbackend.global.error.exception.ErrorCode
import com.example.modeepbackend.global.error.exception.ModeepException

object UserNotFoundException : ModeepException(ErrorCode.USER_NOT_FOUND) {
}
