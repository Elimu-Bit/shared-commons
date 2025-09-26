package com.skillforge.Shared_Commons.utils;

import com.skillforge.Shared_Commons.response.ApiResponse;
import com.skillforge.Shared_Commons.response.ApiResponseFactory;
import com.skillforge.Shared_Commons.response.PaginationInfo;
import com.skillforge.Shared_Commons.response.PaginationInfoFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;


public class ResponseUtils {

    private ResponseUtils() {
        // Utility class
    }

    // ========================================
    // SUCCESS RESPONSES
    // ========================================

    public static <T> ResponseEntity<ApiResponse<T>> ok(T data) {
        return ResponseEntity.ok(ApiResponseFactory.success(data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(T data, String message) {
        return ResponseEntity.ok(ApiResponseFactory.success(data, message));
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(data, "Resource created successfully"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data, String message) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseFactory.success(data, message));
    }

    public static <T> ResponseEntity<ApiResponse<T>> accepted(String message) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(ApiResponseFactory.successWithMessage(message));
    }

    // ========================================
    // PAGINATED RESPONSES
    // ========================================

    public static <T> ResponseEntity<ApiResponse<List<T>>> page(Page<T> page) {
        PaginationInfo pagination = PaginationInfoFactory.of(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                null,
                null
        );

        return ResponseEntity.ok(
                ApiResponseFactory.successBuilder(page.getContent())
                        .pagination(pagination)
                        .build()
        );
    }

    // ========================================
    // ERROR RESPONSES
    // ========================================

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message) {
        return ResponseEntity.badRequest()
                .body(ApiResponseFactory.error(message, "BAD_REQUEST"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message, Map<String, String> fieldErrors) {
        return ResponseEntity.badRequest()
                .body(ApiResponseFactory.validationError(message, fieldErrors));
    }

    public static <T> ResponseEntity<ApiResponse<T>> unauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponseFactory.error("Authentication required", "UNAUTHORIZED"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> forbidden() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ApiResponseFactory.error("Access denied", "FORBIDDEN"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> conflict(String message) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponseFactory.error(message, "CONFLICT"));
    }

    public static <T> ResponseEntity<ApiResponse<T>> internalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponseFactory.error("Internal server error", "INTERNAL_SERVER_ERROR"));
    }

}
