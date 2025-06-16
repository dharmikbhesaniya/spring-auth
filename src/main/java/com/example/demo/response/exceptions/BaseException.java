package com.example.demo.response.exceptions;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
  private final String errorCode;
  private final HttpStatus status;
  private final Object debugInfo;

  public BaseException(String message, String errorCode, HttpStatus status, Object debugInfo) {
    super(message);
    this.errorCode = errorCode;
    this.status = status;
    this.debugInfo = debugInfo;
  }

  public BaseException(String message, String errorCode, HttpStatus status) {
    this(message, errorCode, status, null);
  }

  public String getErrorCode() {
    return errorCode;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public Object getDebugInfo() {
    return debugInfo;
  }
}
