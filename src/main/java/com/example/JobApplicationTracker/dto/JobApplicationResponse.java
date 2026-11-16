package com.example.JobApplicationTracker.dto;

import java.util.Date;

public record JobApplicationResponse (
    long jobId,
    String jobRole,
    String location,
    Date applicationDate
){
}
