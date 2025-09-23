package com.skillforge.Shared_Commons.dtos.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skillforge.Shared_Commons.enums.EnrollmentStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentDTO {

    private long id;

    @NotBlank
    private long userId;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private long courseId;

    @NotBlank
    private String title;

    @NotNull
    private EnrollmentStatus enrollmentStatus;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime enrolledAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime completedAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime expiresAt;

    private long paymentId;
    private boolean isPaid;

    private Double progressPercentage;
    private Integer completedLessons;
    private Integer totalLessons;

    // Helper methods
    public boolean hasExpired() {
        return expiresAt != null && expiresAt.isBefore(LocalDateTime.now());
    }

}
