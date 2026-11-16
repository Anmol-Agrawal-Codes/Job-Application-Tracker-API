package com.example.JobApplicationTracker.dto;

import java.time.LocalDateTime;

public record ApplicationNotFoundErrorResponse(
        LocalDateTime time,
        int status,
        String error,
        String message,
        String path
) {}
