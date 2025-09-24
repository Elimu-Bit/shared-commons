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
@Builder(toBuilder = true)
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
    public static <T> ApiResponseBuilder<T> success() {
        return ApiResponse.<T>builder()
                .success(true)
                .timestamp(LocalDateTime.now());
    }

    public static <T> ApiResponseBuilder<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .timestamp(LocalDateTime.now());
    }

    public static <T> ApiResponseBuilder<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .timestamp(LocalDateTime.now());
    }

    public static <T> ApiResponseBuilder<T> error() {
        return ApiResponse.<T>builder()
                .success(false)
                .timestamp(LocalDateTime.now());
    }

    public static <T> ApiResponseBuilder<T> error(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now());
    }

    public static <T> ApiResponseBuilder<T> error(String message, String errorCode) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .errorCode(errorCode)
                .timestamp(LocalDateTime.now());
    }

    // Builder class for building responses
    public static class ApiResponseBuilder<T> {

        public ApiResponseBuilder<T> withPagination(PaginationInfo pagination) {
            this.pagination = pagination;
            return this;
        }

        public ApiResponseBuilder<T> withPagination(int page, int size, long total) {
            this.pagination = PaginationInfo.of(page, size, total, null, null);
            return this;
        }

        public ApiResponseBuilder<T> withPagination(int page, int size, long total, String sortBy, String sortDir) {
            this.pagination = PaginationInfo.of(page, size, total, sortBy, sortDir);
            return this;
        }

        public ApiResponseBuilder<T> withProcessingTime(long startTimeMs) {
            this.processingTimeMs = System.currentTimeMillis() - startTimeMs;
            return this;
        }

        public ApiResponseBuilder<T> withValidationErrors(Map<String, String> fieldErrors) {
            this.fieldErrors = fieldErrors;
            return this;
        }

        public ApiResponseBuilder<T> withErrorDetails(Map<String, Object> errorDetails) {
            this.errorDetails = errorDetails;
            return this;
        }

        public ApiResponseBuilder<T> withMetadata(String requestId, String serviceName, String path) {
            this.requestId = requestId;
            this.serviceName = serviceName;
            this.path = path;
            return this;
        }

    }

}
