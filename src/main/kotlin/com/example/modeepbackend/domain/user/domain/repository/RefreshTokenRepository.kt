package com.example.modeepbackend.domain.user.domain.repository

import com.example.modeepbackend.domain.user.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {
    fun findByToken(refreshToken: String): RefreshToken
}
