package com.example.JobApplicationTracker.dto;

import com.example.JobApplicationTracker.enums.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatedJobApplicationStatus(
        @NotNull @NotBlank ApplicationStatus status
) {
}
