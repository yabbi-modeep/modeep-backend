package com.example.modeepbackend.domain.user.exception

import com.example.modeepbackend.global.error.exception.ErrorCode
import com.example.modeepbackend.global.error.exception.ModeepException

object UnmatchedPasswordException : ModeepException(ErrorCode.UNMATCHED_PASSWORD) {
}
