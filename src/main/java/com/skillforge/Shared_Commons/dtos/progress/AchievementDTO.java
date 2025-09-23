package com.skillforge.Shared_Commons.dtos.progress;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AchievementDTO {

    private Long id;
    private Long userId;

    private String achievementType;
    private String name;
    private String description;
    private String iconUrl;
    private String badgeUrl;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime earnedAt;

    // Context information
    private Long courseId;
    private String courseName;
    private String criteria;

    // Points/rewards
    private Integer points;
    private String rewardDescription;

}
