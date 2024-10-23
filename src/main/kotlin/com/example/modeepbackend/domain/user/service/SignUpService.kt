package com.example.modeepbackend.domain.user.service

import com.example.modeepbackend.domain.user.domain.User
import com.example.modeepbackend.domain.user.domain.repository.UserRepository
import com.example.modeepbackend.domain.user.presentation.dto.request.SignUpRequest
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class SignUpService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: SignUpRequest) {
        if (!checkUser(request.accountId)) {
            val newUser = User(
                    0,
                    request.accountId,
                    passwordEncoder.encode(request.password),
                    request.name
            )
            userRepository.save(newUser)
        } else {
            throw ResponseStatusException(HttpStatus.CONFLICT, "이미 존재하는 ${request.accountId} 아이디 입니다.")
        }
    }

    fun checkUser(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }
}
