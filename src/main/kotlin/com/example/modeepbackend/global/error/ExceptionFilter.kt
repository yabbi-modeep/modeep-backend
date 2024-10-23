package com.example.modeepbackend.global.error

import com.example.modeepbackend.global.error.exception.ErrorCode
import com.example.modeepbackend.global.error.exception.ModeepException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class ExceptionFilter(
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    @Throws(IOException::class)
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is ModeepException -> writeErrorCode(e, response)
                else -> writeErrorCode(createInternalServerError(), response)
            }
        }
    }

    private fun createInternalServerError(): ModeepException {
        return object : ModeepException(ErrorCode.INTERNAL_SERVER_ERROR) {}
    }

    @Throws(IOException::class)
    private fun writeErrorCode(exception: ModeepException, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(exception)
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = errorResponse.status
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}