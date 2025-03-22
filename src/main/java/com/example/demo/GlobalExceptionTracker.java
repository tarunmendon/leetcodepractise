package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionTracker {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse exceptionHandling(RuntimeException ex) {
        return ErrorResponse.create(ex, HttpStatus.OK, "Runtime exception handled");
    }
}
