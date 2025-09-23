package com.skillforge.Shared_Commons.dtos.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skillforge.Shared_Commons.enums.CourseLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDTO {

    @NotBlank
    private long courseId;

    @NotBlank
    private String title;

    private String description;
    private String shortDescription;

    @NotBlank
    private String category;

    @NotBlank
    private String instructorId;

    @NotBlank
    private String instructorName;

    @PositiveOrZero
    private BigDecimal price;
    private String currency;

    @NotNull
    private CourseLevel level;

    @NotNull
    private String thumbnailUrl;
    @NotNull
    private String previewVideoUrl;

    private Integer estimatedDurationHours;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime publishedAt;

    // Helper methods
    public boolean isPaid() {
        return price != null && price.compareTo(BigDecimal.ZERO) > 0;
    }

}
