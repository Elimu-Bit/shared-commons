package com.skillforge.Shared_Commons.constants;

public class ValidationConstants {

    private ValidationConstants() {
        // Utility class
    }

    // String Length Constraints
    public static final int USERNAME_MIN_LENGTH = 3;
    public static final int USERNAME_MAX_LENGTH = 30;
    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final int PASSWORD_MAX_LENGTH = 100;
    public static final int EMAIL_MAX_LENGTH = 255;

    public static final int COURSE_TITLE_MIN_LENGTH = 5;
    public static final int COURSE_TITLE_MAX_LENGTH = 200;
    public static final int COURSE_DESCRIPTION_MIN_LENGTH = 20;
    public static final int COURSE_DESCRIPTION_MAX_LENGTH = 5000;
    public static final int COURSE_SHORT_DESCRIPTION_MAX_LENGTH = 500;

    public static final int NOTIFICATION_TITLE_MAX_LENGTH = 200;
    public static final int NOTIFICATION_MESSAGE_MAX_LENGTH = 2000;

    // Numeric Constraints
    public static final double MIN_COURSE_PRICE = 0.0;
    public static final double MAX_COURSE_PRICE = 9999.99;
    public static final int MIN_COURSE_DURATION_HOURS = 1;
    public static final int MAX_COURSE_DURATION_HOURS = 1000;

    public static final double MIN_PROGRESS_PERCENTAGE = 0.0;
    public static final double MAX_PROGRESS_PERCENTAGE = 100.0;

    public static final int MIN_QUIZ_SCORE = 0;
    public static final int MAX_QUIZ_SCORE = 100;

    public static final int MIN_SUBSCRIPTION_MONTHS = 1;
    public static final int MAX_SUBSCRIPTION_MONTHS = 36;

    // File Upload Constraints
    public static final long MAX_PROFILE_IMAGE_SIZE = 5 * 1024 * 1024; // 5MB
    public static final long MAX_COURSE_VIDEO_SIZE = 500 * 1024 * 1024; // 500MB
    public static final long MAX_DOCUMENT_SIZE = 10 * 1024 * 1024; // 10MB

    // Allowed File Types
    public static final String[] ALLOWED_IMAGE_TYPES = {"jpg", "jpeg", "png", "gif", "webp"};
    public static final String[] ALLOWED_VIDEO_TYPES = {"mp4", "avi", "mov", "wmv", "flv"};
    public static final String[] ALLOWED_DOCUMENT_TYPES = {"pdf", "doc", "docx", "txt", "rtf"};

    // Pagination Constraints
    public static final int MIN_PAGE_SIZE = 1;
    public static final int MAX_PAGE_SIZE = 100;
    public static final int DEFAULT_PAGE_SIZE = 20;

    // Search Constraints
    public static final int MIN_SEARCH_TERM_LENGTH = 2;
    public static final int MAX_SEARCH_TERM_LENGTH = 100;

    // Business Rule Constants
    public static final int MAX_ENROLLMENTS_PER_USER = 50;
    public static final int MAX_COURSES_PER_INSTRUCTOR = 100;
    public static final int FREE_TRIAL_DAYS = 7;
    public static final int PASSWORD_RESET_TOKEN_VALIDITY_HOURS = 24;
    public static final int EMAIL_VERIFICATION_TOKEN_VALIDITY_HOURS = 72;

    // Regular Expressions
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{3,30}$";
    public static final String PHONE_REGEX = "^\\+?[1-9]\\d{1,14}$";
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8,}$";

}
