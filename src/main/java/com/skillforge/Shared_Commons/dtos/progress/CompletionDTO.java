package com.skillforge.Shared_Commons.dtos.progress;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skillforge.Shared_Commons.enums.CompletionType;
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
public class CompletionDTO {

    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private Long courseId;

    private Long lessonId;
    private String lessonName;

    private Long quizId;
    private String quizName;
    private Double quizScore;

    @NotNull
    private CompletionType type;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime completedAt;

    private Integer timeSpentMinutes;
    private Integer attemptNumber;

    // Additional data based on completion type
    private String additionalData;

    public boolean isLessonCompletion() {
        return CompletionType.LESSON.equals(type);
    }

    public boolean isQuizCompletion() {
        return CompletionType.QUIZ.equals(type);
    }

    public boolean isCourseCompletion() {
        return CompletionType.COURSE.equals(type);
    }

}
