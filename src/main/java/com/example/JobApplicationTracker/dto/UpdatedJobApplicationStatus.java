package com.example.JobApplicationTracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatedJobApplicationStatus(
        @NotNull @NotBlank String status
) {
}
