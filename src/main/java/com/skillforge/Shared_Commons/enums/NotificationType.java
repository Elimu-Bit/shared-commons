package com.skillforge.Shared_Commons.enums;

public enum NotificationType {

    EMAIL("Email"),
    SMS("sms"),
    IN_APP("In-app"),
    PUSH("Push");

    private final String displayName;

    NotificationType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
