package com.example.modeepbackend.domain.user.exception

import com.example.modeepbackend.global.error.exception.ErrorCode
import com.example.modeepbackend.global.error.exception.ModeepException

object AlreadyAccountIdException : ModeepException(ErrorCode.ALREADY_ACCOUNT_ID) {
}
