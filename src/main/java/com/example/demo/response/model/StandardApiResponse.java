package com.example.demo.response.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class StandardApiResponse<T> {
  private final T payload;
  private final String message;
  private final int statusCode;
  private final boolean success;
  private final String path;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime timestamp;
}
