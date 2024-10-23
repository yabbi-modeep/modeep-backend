package com.example.modeepbackend.domain.user.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

class ChangePasswordRequest(
        @field:NotBlank
        @field:Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
                "<=>?@＼^_`{|}~]{8,30}$", message = "소문자, 숫자, 특수문자가 포함어야 하며, 8자 부터 20자 까지만 입력가능합니다.")
        val password: String
)