package com.sachida.barter.rest.api;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    BARTER_INTERNAL_ERROR,
    BARTER_NOT_FOUND(HttpStatus.NOT_FOUND),
    REQUEST_VALIDATION_ERROR(HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT);

    private final HttpStatus statusCode;

    ErrorCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    ErrorCode() {
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public int getStatusCode() {
        return statusCode.value();
    }

}
