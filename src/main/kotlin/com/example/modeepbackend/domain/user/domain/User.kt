package com.example.modeepbackend.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "tbl_user")
class User(
        @Id
        @Column(nullable = false)
        val id: Long,

        @Column(length = 30, nullable = false)
        var accountId: String,

        @Column(length = 200, nullable = false)
        var password: String,

        @Column(length = 10, nullable = false)
        var name: String,
) {
    protected constructor() : this(0, "", "", "")

    constructor(userId: Long) : this(userId, "", "", "")

    //@JsonProperty
    fun updatePassword(password: String) {
        this.password = password
    }

    fun modifyInfo(accountId: String) {
        this.accountId = accountId
    }
}
