package com.example.demobuilt.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract sealed class ApiException extends RuntimeException permits NotFoundException {
    private final HttpStatus httpStatus;

    public ApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
