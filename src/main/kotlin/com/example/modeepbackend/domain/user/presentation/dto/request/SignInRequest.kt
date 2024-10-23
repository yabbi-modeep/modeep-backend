package com.example.modeepbackend.domain.user.presentation.dto.request

import jakarta.validation.constraints.NotBlank

data class SignInRequest(
        @field : NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
        val accountId: String,

        @field:NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
        val password: String
)
