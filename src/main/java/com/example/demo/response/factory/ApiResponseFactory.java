package com.example.demo.response.factory;

import com.example.demo.response.model.StandardApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

/**
 * Factory class for building standardized API responses. Provides utility methods to generate
 * success and error responses with a consistent structure for REST APIs.
 */
public class ApiResponseFactory {

  private static final String DEFAULT_PATH = "N/A";

  /**
   * Builds a standardized API response.
   *
   * @param status HTTP status
   * @param message Response message
   * @param payload Response payload
   * @param request HTTP request (for path extraction)
   * @param isSuccess Success flag (if null, inferred from status)
   * @return ResponseEntity with StandardApiResponse
   */
  public static <T> ResponseEntity<StandardApiResponse<T>> responseBuild(
      HttpStatus status, String message, T payload, HttpServletRequest request, Boolean isSuccess) {
    return ResponseEntity.status(status)
        .body(
            StandardApiResponse.<T>builder()
                .success(isSuccess != null ? isSuccess : status.is2xxSuccessful())
                .statusCode(status.value())
                .message(message)
                .timestamp(LocalDateTime.now())
                .path(request != null ? request.getRequestURI() : DEFAULT_PATH)
                .payload(payload)
                .build());
  }

  // ---------------- SUCCESS METHODS ----------------

  /** Builds a success response with custom status, message, payload, and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(
      HttpStatus status, String message, T payload, HttpServletRequest request) {
    return responseBuild(status, message, payload, request, true);
  }

  /** Builds a success response with custom status, message, and payload. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(
      HttpStatus status, String message, T payload) {
    return responseBuild(status, message, payload, null, true);
  }

  /** Builds a success response with custom status, message, and request. */
  public static ResponseEntity<StandardApiResponse<Void>> success(
      HttpStatus status, String message, HttpServletRequest request) {
    return responseBuild(status, message, null, request, true);
  }

  /** Builds a success response with custom status, payload, and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(
      HttpStatus status, T payload, HttpServletRequest request) {
    return responseBuild(status, null, payload, request, true);
  }

  /** Builds a success response with a custom message, payload, and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(
      String message, T payload, HttpServletRequest request) {
    return responseBuild(HttpStatus.OK, message, payload, request, true);
  }

  /** Builds a success response with custom status and message. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(
      HttpStatus status, String message) {
    return responseBuild(status, message, null, null, true);
  }

  /** Builds a success response with custom status and payload. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(HttpStatus status, T payload) {
    return responseBuild(status, null, payload, null, true);
  }

  /** Builds a success response with custom status and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(
      HttpStatus status, HttpServletRequest request) {
    return responseBuild(status, null, null, request, true);
  }

  /** Builds a success response with a custom message and payload. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(String message, T payload) {
    return responseBuild(HttpStatus.OK, message, payload, null, true);
  }

  /** Builds a success response with a custom message and request. */
  public static ResponseEntity<StandardApiResponse<Void>> success(
      String message, HttpServletRequest request) {
    return responseBuild(HttpStatus.OK, message, null, request, true);
  }

  /** Builds a success response with custom payload and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> success(
      T payload, HttpServletRequest request) {
    return responseBuild(HttpStatus.OK, null, payload, request, true);
  }

  // ---------------- ERROR METHODS ----------------

  /** Builds an error response with custom status, message, payload, and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(
      HttpStatus status, String message, T payload, HttpServletRequest request) {
    return responseBuild(status, message, payload, request, false);
  }

  /** Builds an error response with custom status, message, and payload. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(
      HttpStatus status, String message, T payload) {
    return responseBuild(status, message, payload, null, false);
  }

  /** Builds an error response with custom status, message, and request. */
  public static ResponseEntity<StandardApiResponse<Void>> error(
      HttpStatus status, String message, HttpServletRequest request) {
    return responseBuild(status, message, null, request, false);
  }

  /** Builds an error response with custom status, payload, and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(
      HttpStatus status, T payload, HttpServletRequest request) {
    return responseBuild(status, null, payload, request, false);
  }

  /** Builds an error response with a custom message, payload, and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(
      String message, T payload, HttpServletRequest request) {
    return responseBuild(HttpStatus.BAD_REQUEST, message, payload, request, false);
  }

  /** Builds an error response with custom status and message. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(
      HttpStatus status, String message) {
    return responseBuild(status, message, null, null, false);
  }

  /** Builds an error response with custom status and payload. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(HttpStatus status, T payload) {
    return responseBuild(status, null, payload, null, false);
  }

  /** Builds an error response with custom status and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(
      HttpStatus status, HttpServletRequest request) {
    return responseBuild(status, null, null, request, false);
  }

  /** Builds an error response with a custom message and payload. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(String message, T payload) {
    return responseBuild(HttpStatus.BAD_REQUEST, message, payload, null, false);
  }

  /** Builds an error response with a custom message and request. */
  public static ResponseEntity<StandardApiResponse<Void>> error(
      String message, HttpServletRequest request) {
    return responseBuild(HttpStatus.BAD_REQUEST, message, null, request, false);
  }

  /** Builds an error response with custom payload and request. */
  public static <T> ResponseEntity<StandardApiResponse<T>> error(
      T payload, HttpServletRequest request) {
    return responseBuild(HttpStatus.BAD_REQUEST, null, payload, request, false);
  }
}

// Overload combinations for API response methods:

// 1. status, message
// 2. status, payload
// 3. status, request
// 4. message, payload
// 5. message, request
// 6. payload, request

// 7. status, message, payload
// 8. status, message, request
// 9. status, payload, request
// 10. message, payload, request

// 11. status, message, payload, request
