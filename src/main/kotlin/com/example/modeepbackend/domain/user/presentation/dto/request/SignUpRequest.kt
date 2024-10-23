package com.example.modeepbackend.domain.user.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SignUpRequest(
        @field:NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
        @field:Size(min = 8, max = 20, message = "8자 부터 20자 까지만 입력가능합니다.")
        val accountId: String,

        @field:NotBlank
        @field:Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
                "<=>?@＼^_`{|}~]{8,30}$", message = "소문자, 숫자, 특수문자가 포함어야 하며, 8자 부터 20자 까지만 입력가능합니다.")
        val password: String,

        @field:NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
        @field:Size(min = 2, max = 10, message = "2자 부터 10자 까지만 입력가능합니다.")
        val name: String
)
