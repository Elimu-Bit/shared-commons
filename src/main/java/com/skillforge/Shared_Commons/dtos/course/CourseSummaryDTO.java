package com.skillforge.Shared_Commons.dtos.course;

import com.skillforge.Shared_Commons.enums.CourseLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseSummaryDTO {

    private Long courseId;
    private String title;
    private String shortDescription;
    private String instructorName;
    private String category;
    private CourseLevel level;
    private BigDecimal price;
    private String currency;
    private String thumbnailUrl;
    private Integer estimatedDurationHours;

    // For enrollment context
    private boolean isEnrolled;
    private boolean isPaid;

}
