package com.skillforge.Shared_Commons.dtos.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skillforge.Shared_Commons.enums.SubscriptionStatus;
import com.skillforge.Shared_Commons.enums.SubscriptionType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SubscriptionDTO {

    private Long id;

    @NotNull
    private Long userId;
    private String userEmail;

    @NotNull
    private SubscriptionType type;

    @NotNull
    private SubscriptionStatus status;

    @NotNull
    private BigDecimal price;
    private String currency;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime nextBillingDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime cancelledAt;

    private String cancellationReason;

    // Payment information
    private Long paymentMethodId;
    private String lastPaymentId;


    // Helper methods
    public boolean isActive() {
        return SubscriptionStatus.ACTIVE.equals(status);
    }

    public boolean hasExpired() {
        return endDate != null && endDate.isBefore(LocalDateTime.now());
    }


}
