package com.skillforge.Shared_Commons.enums;

public enum PaymentStatus {

    PENDING("Pending"),
    PROCESSING("Processing"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    CANCELLED("Cancelled"),
    REFUNDED("Refunded"),
    PARTIALLY_REFUNDED("Partially Refunded");

    private final String displayName;

    PaymentStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isSuccessful() {
        return this == COMPLETED;
    }

    public boolean isInProgress() {
        return this == PENDING || this == PROCESSING;
    }

    public boolean isFinal() {
        return this == COMPLETED || this == FAILED ||
                this == CANCELLED || this == REFUNDED;
    }

}
