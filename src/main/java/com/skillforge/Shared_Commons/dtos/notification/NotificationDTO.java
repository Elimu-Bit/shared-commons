package com.skillforge.Shared_Commons.dtos.notification;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skillforge.Shared_Commons.enums.NotificationStatus;
import com.skillforge.Shared_Commons.enums.NotificationType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDTO {
    private Long id;

    @NotNull
    private Long userId;
    private String userEmail;

    @NotNull
    private NotificationType type;

    @NotNull
    private String title;

    @NotNull
    private String message;

    // Rich content
    private String htmlContent;
    private String imageUrl;
    private String actionUrl;
    private String actionText;

    // Delivery information
    private NotificationStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime scheduledAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime sentAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime readAt;

    // Additional data for templating
    private Map<String, Object> templateData;

    // Helper methods
    public boolean isRead() {
        return readAt != null;
    }

    public boolean isSent() {
        return NotificationStatus.SENT.equals(status);
    }

    public boolean isPending() {
        return NotificationStatus.PENDING.equals(status);
    }
}
