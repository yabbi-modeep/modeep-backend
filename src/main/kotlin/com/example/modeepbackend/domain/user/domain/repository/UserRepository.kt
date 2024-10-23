package com.example.modeepbackend.domain.user.domain.repository

import com.example.modeepbackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByAccountId(accountId: String): User?
    fun existsByAccountId(accountId: String): Boolean
}
