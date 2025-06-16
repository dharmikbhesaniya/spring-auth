package com.example.demo.response.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {
  public BadRequestException(String message) {
    super(message, "BAD_REQUEST", HttpStatus.BAD_REQUEST);
  }
}
