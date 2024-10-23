package com.example.modeepbackend

import com.example.modeepbackend.global.security.jwt.TokenProperties
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(TokenProperties:: class)
@SpringBootApplication
class ModeepBackendApplication

fun main(args: Array<String>) {
    runApplication<ModeepBackendApplication>(*args)
}
