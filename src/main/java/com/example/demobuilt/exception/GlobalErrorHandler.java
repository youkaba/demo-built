package com.example.demobuilt.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public record GlobalErrorHandler(HttpServletRequest request) {


    public record ErrorResponse(HttpStatus httpStatus, LocalDateTime dateTime, String message, String description) {

    }
}
