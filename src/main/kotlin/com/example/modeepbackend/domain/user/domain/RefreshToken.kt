package com.example.modeepbackend.domain.user.domain

import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "RefreshToken", timeToLive = 60 * 60 * 2)
class RefreshToken(

        @Id
        var accountId: String,

        @Indexed
        @get:NotBlank
        val token: String
)
