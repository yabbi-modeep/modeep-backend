package com.example.modeepbackend.global.error.exception

enum class ErrorCode(
        val status: Int,
        val message: String,
) {
    UNMATCHED_PASSWORD(400, "Unmatched Password"),
    INCORRECT_PASSWORD(400, "Incorrect Password"),
    INCORRECT_USER(400, "Incorrect User"),

    TOKEN_INVALID(401, "Token Invalid"),
    TOKEN_EXPIRED(401, "Token Expired"),

    USER_NOT_FOUND(404, "User Not Found"),

    ALREADY_ACCOUNT_ID(409, "Already Account Id"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}
