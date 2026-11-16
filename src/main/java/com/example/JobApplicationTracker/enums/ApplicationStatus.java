package com.example.JobApplicationTracker.enums;

import java.util.Set;

public enum ApplicationStatus {
    APPLIED,
    SCREENING,
    INTERVIEW,
    OFFER,
    REJECTED,
    WITHDRAWN;

    private Set<ApplicationStatus> nextAllowedStatus() {
        return switch(this){
            case APPLIED -> Set.of(SCREENING, REJECTED, WITHDRAWN);
            case SCREENING -> Set.of(INTERVIEW, REJECTED, WITHDRAWN);
            case INTERVIEW -> Set.of(OFFER, REJECTED, WITHDRAWN);
            case OFFER -> Set.of(WITHDRAWN);
            case REJECTED, WITHDRAWN -> Set.of();
        };
    }

    public boolean canTransitionTo(ApplicationStatus applicationStatus) {
        if (this == applicationStatus) return true;
        return nextAllowedStatus().contains(applicationStatus);
    }
}