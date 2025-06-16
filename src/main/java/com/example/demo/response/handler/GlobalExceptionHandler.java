package com.example.demo.response.handler;

import com.example.demo.response.factory.ApiResponseFactory;
import com.example.demo.response.exceptions.BaseException;
import com.example.demo.response.model.StandardApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<StandardApiResponse<Object>> handleBaseException(BaseException ex, HttpServletRequest request) {
        return ApiResponseFactory.error(
                ex.getStatus(),
                ex.getMessage(),
                ex.getDebugInfo(), // Payload (can be null or contain useful debug info)
                request
        );
    }

    // Optionally handle other exceptions too
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardApiResponse<Object>> handleGenericException(Exception ex, HttpServletRequest request) {
        return ApiResponseFactory.error(
                "Internal server error",
                ex.getMessage(), // You may want to hide in prod
                request
        );
    }
}
