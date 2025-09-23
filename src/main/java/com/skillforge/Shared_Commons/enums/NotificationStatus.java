package com.skillforge.Shared_Commons.enums;

import lombok.Getter;

@Getter
public enum NotificationStatus {
    PENDING("Pending"),
    SENT("Sent"),
    DELIVERED("Delivered"),
    READ("Read"),
    FAILED("Failed"),
    CANCELLED("Cancelled");

    private final String displayName;

    NotificationStatus(String displayName) {
        this.displayName  = displayName;
    }

    public boolean isSuccessful() {
        return this == SENT || this == DELIVERED || this == READ;
    }

    public boolean isFinal() {
        return this == DELIVERED || this == READ || this == FAILED || this == CANCELLED;
    }

}
