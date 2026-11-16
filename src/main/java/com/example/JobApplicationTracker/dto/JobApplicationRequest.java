package com.example.JobApplicationTracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record JobApplicationRequest(
    @NotNull(message = "Job ID is required")
    @Positive(message = "Job ID must be positive")
    Long jobId,
    @NotBlank String companyName,
    @NotBlank String jobRole,
    @NotBlank String location,
    @NotBlank LocalDate applicationDate,
    @NotBlank String jobUrl
) {}
