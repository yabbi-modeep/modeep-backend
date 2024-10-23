package com.example.modeepbackend.domain.user.presentation

import com.example.modeepbackend.domain.user.presentation.dto.request.ChangePasswordRequest
import com.example.modeepbackend.domain.user.presentation.dto.request.ModifyInfoRequest
import com.example.modeepbackend.domain.user.presentation.dto.request.SignInRequest
import com.example.modeepbackend.domain.user.presentation.dto.request.SignUpRequest
import com.example.modeepbackend.domain.user.presentation.dto.response.TokenResponse
import com.example.modeepbackend.domain.user.presentation.dto.response.UserInfoResponse
import com.example.modeepbackend.domain.user.service.*
import com.example.modeepbackend.global.security.jwt.TokenProvider
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/users")
@RestController
class UserController(

        private val signUpService: SignUpService,
        private val signInService: SignInService,
        private val userInfoService: UserInfoService,
        private val tokenProvider: TokenProvider,
        private val userModifyService: UserModifyService,
        private val changePasswordService: ChangePasswordService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid request: SignUpRequest) {
        signUpService.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    fun login(@RequestBody @Valid request: SignInRequest): TokenResponse {
        return signInService.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/token")
    fun refreshToken(@RequestHeader("Authorization") authorization: String): ResponseEntity<Any> {
        val token = authorization.removePrefix("Bear").trim()

        return if (tokenProvider.validateToken(token)) {
            val newToken = tokenProvider.generateToken(token)
            ResponseEntity.ok().body(mapOf("token" to newToken))
        } else {
            ResponseEntity.badRequest().body("Invalid token")
        }
    }

    @GetMapping("/{account-id}")
    fun checkUser(@PathVariable("account-id") accountId: String): Boolean {
        return signUpService.checkUser(accountId)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    fun getUserInfo(): UserInfoResponse {
        return userInfoService.execute()
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/modify")
    fun modify(@RequestBody @Valid request: ModifyInfoRequest) {
        return userModifyService.userModify(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/password")
    fun password(@RequestBody @Valid request: ChangePasswordRequest) {
        return changePasswordService.changePassword(request)
    }
}
