package com.skillforge.Shared_Commons.enums;

public enum EnrollmentStatus {

    PENDING("Pending"),
    ACTIVE("Active"),
    COMPLETED("Completed"),
    DROPPED("Dropped"),
    EXPIRED("Expired"),
    SUSPENDED("Suspended");

    private final String displayName;

    EnrollmentStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isActiveEnrollment() {
        return this == ACTIVE || this == PENDING;
    }

    public boolean canAccessCourse() {
        return this == ACTIVE;
    }

}
