package com.skillforge.Shared_Commons.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    //Core response fields
    private boolean success;
    private String message;
    private T data;

    //Error-specific fields
    private String errorCode;
    private List<String> errors;
    private Map<String, String> fieldErrors;
    private Map<String, Object> errorDetails;

    // Metadata
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    private String requestId;
    private String serviceName;
    private String path;
    private String version;

    private PaginationInfo pagination;

    private long processingTimeMs;

    // Builder responses
    public static <T> ApiResponse<T> success() {
        return ApiResponse.<T>builder()
                .success(true)
                .timestamp(LocalDateTime.now()).build();
    }

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .timestamp(LocalDateTime.now()).build();
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .timestamp(LocalDateTime.now()).build();
    }

    public static <T> ApiResponse<T> error() {
        return ApiResponse.<T>builder()
                .success(false)
                .timestamp(LocalDateTime.now()).build();
    }

    public static <T> ApiResponse<T> error(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now()).build();
    }

    public static <T> ApiResponse<T> error(String message, String errorCode) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .errorCode(errorCode)
                .timestamp(LocalDateTime.now()).build();
    }

    public static <T> ApiResponse<T> withPagination(PaginationInfo pagination) {
        return ApiResponse.<T>builder()
                .pagination(pagination)
                .build();
    }

    public  static <T> ApiResponse<T> withPagination( int page, int size, long total) {
        return ApiResponse.<T>builder()
                .pagination(PaginationInfo.of(page, size, total, null, null))
                .build();
    }

    public static <T> ApiResponse<T> withPagination(int page, int size, long total, String sortBy, String sortDir) {
        return ApiResponse.<T>builder()
                .pagination(PaginationInfo.of(page, size, total, sortBy, sortDir))
                .build();
    }

    public static <T> ApiResponse<T> withProcessingTime(long startTimeMs) {
        return ApiResponse.<T>builder()
                .processingTimeMs(System.currentTimeMillis() - startTimeMs)
                .build();
    }

    public static <T> ApiResponse<T> withValidationErrors(Map<String, String> fieldErrors) {
        return ApiResponse.<T>builder()
                .fieldErrors(fieldErrors)
                .build();
    }

    public static <T> ApiResponse<T> withErrorDetails(Map<String, Object> details) {
        return ApiResponse.<T>builder()
                .errorDetails(details)
                .build();
    }

    public static <T> ApiResponse<T> withMetadata(String requestId, String serviceName, String path) {
        return ApiResponse.<T>builder()
                .requestId(requestId)
                .serviceName(serviceName)
                .path(path)
                .build();
    }

}
