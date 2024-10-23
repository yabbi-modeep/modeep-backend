package com.example.modeepbackend.domain.user.service

import com.example.modeepbackend.domain.user.facade.UserFacade
import com.example.modeepbackend.domain.user.presentation.dto.response.UserInfoResponse
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserInfoService(
        private val userFacade: UserFacade,
) {

    @Transactional
    fun execute(): UserInfoResponse {
        val user = userFacade.getCurrentUser()
        return UserInfoResponse(user.name, user.accountId, user.password)
    }
}
