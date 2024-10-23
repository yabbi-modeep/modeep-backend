package com.example.modeepbackend.domain.user.service

import com.example.modeepbackend.domain.user.domain.repository.UserRepository
import com.example.modeepbackend.domain.user.facade.UserFacade
import com.example.modeepbackend.domain.user.presentation.dto.request.ChangePasswordRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ChangePasswordService(
        private val userRepository: UserRepository,
        private val userFacade: UserFacade
) {

    @Transactional
    fun changePassword(request: ChangePasswordRequest) {
        val user = userFacade.getCurrentUser()
        user.updatePassword(request.password)

        userRepository.save(user)
    }
}
