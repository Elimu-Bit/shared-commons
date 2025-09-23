package com.skillforge.Shared_Commons.dtos.progress;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificateDTO {

    private Long id;

    @NotNull
    private Long userId;
    private String userName;

    @NotNull
    private Long courseId;
    private String courseName;

    @NotNull
    private String certificateNumber;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime issuedAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime expiresAt;

    private String certificateUrl;
    private String verificationUrl;

    private Double finalScore;
    private String grade;

    private String instructorName;
    private String instructorSignature;

    // Certificate template information
    private String templateId;
    private String templateVersion;

    public boolean isValid() {
        return expiresAt == null || expiresAt.isAfter(LocalDateTime.now());
    }

}
