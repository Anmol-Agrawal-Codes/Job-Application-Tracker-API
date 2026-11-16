package com.example.JobApplicationTracker;

import com.example.JobApplicationTracker.dto.ApplicationNotFoundErrorResponse;
import com.example.JobApplicationTracker.errors.ApplicationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<ApplicationNotFoundErrorResponse> handleApplicationNotFound(
            ApplicationNotFoundException ex, WebRequest request) {

        ApplicationNotFoundErrorResponse error = new ApplicationNotFoundErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
