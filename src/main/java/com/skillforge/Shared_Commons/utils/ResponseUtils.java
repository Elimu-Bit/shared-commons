package com.skillforge.Shared_Commons.utils;

import com.skillforge.Shared_Commons.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;


public class ResponseUtils {

    private ResponseUtils() {
        // Utility class
    }

    // Success Responses
    public static <T> ResponseEntity<ApiResponse<T>> ok(T data) {
        return ResponseEntity.ok(
                ApiResponse.success(data).build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(T data, String message) {
        return ResponseEntity.ok(
                ApiResponse.success(data, message).build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.success(data, "Resource created successfully").build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data, String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.success(data, message).build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> accepted(String message) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                ApiResponse.<T>success()
                        .message(message)
                        .build()
        );
    }

    // Error responses
    public static ResponseEntity<ApiResponse<Void>> noContent() {
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message) {
        return ResponseEntity.badRequest().body(
                ApiResponse.<T>error(message, "BAD_REQUEST").build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequest(String message, Map<String, String> fieldErrors) {
        return ResponseEntity.badRequest().body(
                ApiResponse.<T>error(message, "VALIDATION_ERROR")
                        .withValidationErrors(fieldErrors)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> unauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ApiResponse.<T>error("Authentication required", "UNAUTHORIZED").build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> forbidden() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                ApiResponse.<T>error("Access denied", "FORBIDDEN").build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> notFound(String resourceType, Object id) {
        return ResponseEntity.notFound().build();
    }

    public static <T> ResponseEntity<ApiResponse<T>> conflict(String message) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ApiResponse.<T>error(message, "CONFLICT").build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> unprocessableEntity(String message, String errorCode) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                ApiResponse.<T>error(message, errorCode).build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> internalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse.<T>error("Internal server error", "INTERNAL_SERVER_ERROR").build()
        );
    }

}
