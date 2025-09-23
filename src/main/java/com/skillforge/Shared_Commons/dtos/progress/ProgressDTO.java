package com.skillforge.Shared_Commons.dtos.progress;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skillforge.Shared_Commons.enums.ProgressStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressDTO {

    private Long id;

    @NotNull
    private Long userId;
    private String userName;

    @NotNull
    private Long courseId;
    private String courseName;

    @NotNull
    private Long enrollmentId;

    @NotNull
    private ProgressStatus status;

    @Min(0)
    @Max(100)
    private Double completionPercentage;

    private Integer completedLessons;
    private Integer totalLessons;

    private Integer completedQuizzes;
    private Integer totalQuizzes;

    private Integer totalTimeSpentMinutes;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startedAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime lastAccessedAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime completedAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    // Current position in course
    private Long currentLessonId;
    private String currentLessonName;
    private Integer currentLessonPosition;

    // Performance metrics
    private Double averageQuizScore;
    private Integer streakDays;
    private Integer totalLoginDays;

    // Certificates and achievements
    private List<CertificateDTO> certificates;
    private List<AchievementDTO> achievements;

    // Helper methods
    public boolean isCompleted() {
        return ProgressStatus.COMPLETED.equals(status) ||
                (completionPercentage != null && completionPercentage >= 100.0);
    }

    public boolean isInProgress() {
        return ProgressStatus.IN_PROGRESS.equals(status);
    }

    public int getRemainingLessons() {
        if (totalLessons == null || completedLessons == null) return 0;
        return Math.max(0, totalLessons - completedLessons);
    }

}
