package com.skillforge.Shared_Commons.enums;

import lombok.Getter;

public enum SubscriptionStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    CANCELLED("Cancelled"),
    EXPIRED("Expired"),
    SUSPENDED("Suspended"),
    PENDING("Pending"),
    TRIAL("Trial");

    @Getter
    private final String displayName;

    SubscriptionStatus(String displayName) {
        this.displayName = displayName;
    }

    public boolean allowsAccess() {
        return this == ACTIVE || this == TRIAL;
    }

    public boolean canBeReactivated() {
        return this == CANCELLED || this == EXPIRED || this == SUSPENDED;
    }

}
