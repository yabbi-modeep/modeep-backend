package com.example.modeepbackend.domain.user.service

import com.example.modeepbackend.domain.user.domain.repository.UserRepository
import com.example.modeepbackend.domain.user.facade.UserFacade
import com.example.modeepbackend.domain.user.presentation.dto.request.ModifyInfoRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserModifyService(
        private val userFacade: UserFacade,
        private val userRepository: UserRepository,
) {

    @Transactional
    fun userModify(request: ModifyInfoRequest) {
        val user = userFacade.getCurrentUser()
        user.modifyInfo(request.accountId)

        userRepository.save(user)
    }
}
