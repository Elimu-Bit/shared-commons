package com.skillforge.Shared_Commons.constants;

public final class ApiConstants {

    private ApiConstants() {
        //Prevent instantiation
    }

    // API Versioning
    public static final String API_VERSION = "v1";
    public static final String API_BASE_PATH = "/api/" + API_VERSION;

    // Service Names (for service-to-service communication)
    public static final String USER_SERVICE = "user-service";
    public static final String COURSE_SERVICE = "course-service";
    public static final String PAYMENT_SERVICE = "payment-service";
    public static final String NOTIFICATION_SERVICE = "notification-service";
    public static final String PROGRESS_TRACKING_SERVICE = "progress-tracking-service";
    public static final String MONITORING_SERVICE = "monitoring-service";

    // Common Headers
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String USER_ID_HEADER = "X-User-ID";
    public static final String REQUEST_ID_HEADER = "X-Request-ID";
    public static final String CLIENT_VERSION_HEADER = "X-Client-Version";

    // Pagination
    public static final String DEFAULT_PAGE_SIZE = "20";
    public static final String MAX_PAGE_SIZE = "100";
    public static final String DEFAULT_SORT_DIRECTION = "asc";
    public static final String SORT_PARAM = "sort";
    public static final String PAGE_PARAM = "page";
    public static final String SIZE_PARAM = "size";

    // Rate Limiting
    public static final int DEFAULT_RATE_LIMIT = 100; // requests per minute
    public static final int AUTH_RATE_LIMIT = 5; // login attempts per minute
    public static final int UPLOAD_RATE_LIMIT = 5; // file uploads per minute

    // Content Types
    public static final String JSON_CONTENT_TYPE = "application/json";
    public static final String XML_CONTENT_TYPE = "application/xml";
    public static final String FORM_DATA_CONTENT_TYPE = "multipart/form-data";

    // Cache Keys Prefixes
    public static final String USER_CACHE_PREFIX = "user:";
    public static final String COURSE_CACHE_PREFIX = "course:";
    public static final String ENROLLMENT_CACHE_PREFIX = "enrollment:";
    public static final String PROGRESS_CACHE_PREFIX = "progress:";

    // Cache TTL (Time To Live) in seconds
    public static final long USER_CACHE_TTL = 3600; // 1 hour
    public static final long COURSE_CACHE_TTL = 7200; // 2 hours
    public static final long ENROLLMENT_CACHE_TTL = 1800; // 30 minutes
    public static final long PROGRESS_CACHE_TTL = 900; // 15 minutes



}
