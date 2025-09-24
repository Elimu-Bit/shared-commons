package com.skillforge.Shared_Commons.constants;

public final class MessageConstants {

    private MessageConstants() {
        //Utility class
    }

    // Success Messages
    public static final String USER_CREATED_SUCCESS = "User account created successfully";
    public static final String USER_UPDATED_SUCCESS = "User profile updated successfully";
    public static final String COURSE_CREATED_SUCCESS = "Course created successfully";
    public static final String COURSE_PUBLISHED_SUCCESS = "Course published successfully";
    public static final String ENROLLMENT_SUCCESS = "Successfully enrolled in course";
    public static final String PAYMENT_SUCCESS = "Payment processed successfully";
    public static final String PASSWORD_RESET_SUCCESS = "Password reset email sent successfully";

    // Error Messages
    public static final String INVALID_CREDENTIALS = "Invalid username or password";
    public static final String ACCESS_DENIED = "Access denied. Insufficient permissions";
    public static final String RESOURCE_NOT_FOUND = "Requested resource not found";
    public static final String VALIDATION_FAILED = "Input validation failed";
    public static final String INTERNAL_SERVER_ERROR = "An internal server error occurred";
    public static final String SERVICE_UNAVAILABLE = "Service is temporarily unavailable";

    // Business Rule Messages
    public static final String COURSE_NOT_AVAILABLE = "Course is not available for enrollment";
    public static final String ALREADY_ENROLLED = "You are already enrolled in this course";
    public static final String SUBSCRIPTION_REQUIRED = "Active subscription required to access this content";
    public static final String PAYMENT_REQUIRED = "Payment required to enroll in this course";
    public static final String COURSE_CAPACITY_FULL = "Course has reached maximum enrollment capacity";

    // Validation Messages
    public static final String INVALID_EMAIL_FORMAT = "Please provide a valid email address";
    public static final String PASSWORD_TOO_WEAK = "Password must be at least 8 characters with uppercase, lowercase, and digit";
    public static final String USERNAME_ALREADY_EXISTS = "Username is already taken";
    public static final String EMAIL_ALREADY_EXISTS = "Email address is already registered";
    public static final String REQUIRED_FIELD_MISSING = "Required field is missing: %s";

    // Notification Messages
    public static final String WELCOME_MESSAGE = "Welcome to our learning platform!";
    public static final String ENROLLMENT_CONFIRMATION = "You have been successfully enrolled in: %s";
    public static final String COURSE_COMPLETION = "Congratulations! You have completed: %s";
    public static final String PAYMENT_CONFIRMATION = "Payment confirmation for: %s";
    public static final String SUBSCRIPTION_EXPIRY_WARNING = "Your subscription will expire in %d days";

}
