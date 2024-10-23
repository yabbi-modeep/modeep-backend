package com.example.modeepbackend.domain.user.service

import com.example.modeepbackend.domain.user.exception.IncorrectPasswordException
import com.example.modeepbackend.domain.user.facade.UserFacade
import com.example.modeepbackend.domain.user.presentation.dto.request.SignInRequest
import com.example.modeepbackend.domain.user.presentation.dto.response.TokenResponse
import com.example.modeepbackend.global.security.jwt.TokenProvider
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignInService(
        private val userFacade: UserFacade,
        private val passwordEncoder: PasswordEncoder,
        private val tokenProvider: TokenProvider,
) {
    @Transactional
    fun execute(request: SignInRequest): TokenResponse {
        val user = userFacade.getByAccountId(request.accountId)
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw IncorrectPasswordException
        }
        return tokenProvider.generateToken(user.accountId)
    }
}
