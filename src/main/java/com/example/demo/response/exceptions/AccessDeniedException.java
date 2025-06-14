package com.example.demo.response.exceptions;

import org.springframework.http.HttpStatus;

public class AccessDeniedException extends BaseException {
    public AccessDeniedException(String message) {
        super(message, "FORBIDDEN", HttpStatus.FORBIDDEN);
    }
}
