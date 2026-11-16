package com.example.JobApplicationTracker.dto;

import java.time.LocalDate;

public record JobApplicationResponse (
    Long jobId,
    String companyName,
    String jobRole,
    String location,
    LocalDate applicationDate
){
}
