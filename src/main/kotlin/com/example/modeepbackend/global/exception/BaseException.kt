package com.example.modeepbackend.global.exception

abstract class BaseException : RuntimeException() {
    abstract fun getExceptionType(): BaseExceptionType
}
