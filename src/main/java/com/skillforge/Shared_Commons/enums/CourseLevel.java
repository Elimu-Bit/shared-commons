package com.skillforge.Shared_Commons.enums;


import lombok.Getter;

public enum CourseLevel {
    BEGINNER("Beginner", 1),
    INTERMEDIATE("Intermediate", 2),
    ADVANCED("Advanced", 3),
    EXPERT("Expert", 4);

    @Getter
    private final String displayName;

    @Getter
    private final int level;

    CourseLevel(String displayName, int level) {
        this.displayName = displayName;
        this.level = level;
    }

    public boolean isMoreAdvancedThan(CourseLevel other) {
        return this.level > other.level;
    }

}
