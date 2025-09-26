package com.skillforge.Shared_Commons.response;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiResponseFactory {

    private ApiResponseFactory() {
        // Utility class
    }

    // ========================================
    // SUCCESS RESPONSES
    // ========================================

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> successWithMessage(String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ========================================
    // ERROR RESPONSES
    // ========================================

    public static <T> ApiResponse<T> error(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> error(String message, String errorCode) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .errorCode(errorCode)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> validationError(String message, Map<String, String> fieldErrors) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .errorCode("VALIDATION_ERROR")
                .fieldErrors(fieldErrors)
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ========================================
    // BUILDER EXTENSIONS (CONVENIENCE METHODS)
    // ========================================

    public static <T> ApiResponse.ApiResponseBuilder<T> successBuilder() {
        return ApiResponse.<T>builder()
                .success(true)
                .timestamp(LocalDateTime.now());
    }

    public static <T> ApiResponse.ApiResponseBuilder<T> errorBuilder() {
        return ApiResponse.<T>builder()
                .success(false)
                .timestamp(LocalDateTime.now());
    }

    public static <T> ApiResponse.ApiResponseBuilder<T> successBuilder(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .timestamp(LocalDateTime.now());
    }

    public static <T> ApiResponse.ApiResponseBuilder<T> errorBuilder(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now());
    }

}
