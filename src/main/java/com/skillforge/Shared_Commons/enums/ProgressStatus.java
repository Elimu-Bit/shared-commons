package com.skillforge.Shared_Commons.enums;

import lombok.Getter;

@Getter
public enum ProgressStatus {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    PAUSED("Paused");

    private final String displayName;

    ProgressStatus(String displayName) {
        this.displayName = displayName;
    }

    public boolean isActive() {
        return this == IN_PROGRESS;
    }

    public boolean isCompleted() {
        return this == COMPLETED;
    }
}
