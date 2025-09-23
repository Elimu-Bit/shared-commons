package com.skillforge.Shared_Commons.enums;

import lombok.Getter;

public enum CompletionType {

    LESSON("Lesson"),
    QUIZ("Quiz"),
    COURSE("Course");

    @Getter
    private final String displayName;

    CompletionType(String displayName) {
        this.displayName = displayName;
    }

}
