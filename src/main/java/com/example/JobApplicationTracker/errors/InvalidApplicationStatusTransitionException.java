package com.example.JobApplicationTracker.errors;

public class InvalidApplicationStatusTransitionException extends RuntimeException {
    public InvalidApplicationStatusTransitionException(String message) {
        super(message);
    }
}
