package com.skillforge.Shared_Commons.dtos.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skillforge.Shared_Commons.enums.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {

    private long id;

    @NotNull
    private long userId;
    @NotNull
    private String email;

    @NotNull
    private long courseId;
    @NotNull
    private String title;

    @NotNull
    @Positive
    private BigDecimal amount;
    @NotNull
    private String currency;

    private String paymentMethod; // card, e-payment, crypto currency etc

    @NotNull
    private PaymentStatus status; // update to enum

    @NotNull
    private String transactionId;
    @NotNull
    private String gatewayTransactionId;
    private String gatewayName;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime processedAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime refundedAt;
    private String refundingReason;
    @NotNull
    private BigDecimal refundedAmount;

    private Map<String, String> metadata;

    private String subscriptionId;
    private String subscriptionPlan;

    //Billing info
    private String address;
    private String city;
    private String country;
    private String postalCode;

    // Helper methods
    public boolean isSuccessful() {
        return PaymentStatus.COMPLETED.equals(status);
    }

    public boolean isPending() {
        return PaymentStatus.PENDING.equals(status) ||
                PaymentStatus.PROCESSING.equals(status);
    }

    public boolean canBeRefunded() {
        return PaymentStatus.COMPLETED.equals(status) &&
                (refundedAmount == null || refundedAmount.compareTo(amount) < 0);
    }

}
