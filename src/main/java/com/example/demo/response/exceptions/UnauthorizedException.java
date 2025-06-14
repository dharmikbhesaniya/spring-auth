package com.example.demo.response.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException(String message) {
        super(message, "UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }
}
