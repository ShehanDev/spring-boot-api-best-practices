package com.shehan.workflow_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.time.LocalDateTime;
@Data
public class ErrorResponse {
    private String message;
    private String details;
    private LocalDateTime timestamp;
    //private HttpStatusCode statusCode;

    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
      // this.statusCode = statusCode;
    }

}
