package com.example.JobApplicationTracker.dto;

import java.time.LocalDateTime;

public record InvalidApplicationStatusTransitionErrorResponse(
        LocalDateTime time,
        int status,
        String error,
        String message,
        String path
) {
}
