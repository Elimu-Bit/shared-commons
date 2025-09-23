package com.skillforge.Shared_Commons.enums;

import lombok.Getter;

public enum SubscriptionType {

    MONTHLY("Monthly", 1),
    QUARTERLY("Quarterly", 3),
    ANNUALLY("Annually", 12);

    @Getter
    private final String displayName;
    @Getter
    private final int months;

    SubscriptionType(String displayName, int months) {
        this.displayName = displayName;
        this.months = months;
    }

}
