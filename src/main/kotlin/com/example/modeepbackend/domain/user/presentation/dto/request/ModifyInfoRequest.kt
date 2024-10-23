package com.example.modeepbackend.domain.user.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class ModifyInfoRequest(
        @field:NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
        @field:Size(min = 8, max = 20, message = "8자 부터 20자 까지만 입력가능합니다.")
        val accountId: String
)