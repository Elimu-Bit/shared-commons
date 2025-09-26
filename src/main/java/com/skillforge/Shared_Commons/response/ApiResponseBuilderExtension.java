package com.skillforge.Shared_Commons.response;

public class ApiResponseBuilderExtension {

    public static <T> ApiResponse.ApiResponseBuilder<T> withPagination(
            ApiResponse.ApiResponseBuilder<T> builder,
            int page, int size, long total) {

        PaginationInfo pagination = PaginationInfoFactory.of(page, size, total, null, null);
        return builder.pagination(pagination);
    }

    public static <T> ApiResponse.ApiResponseBuilder<T> withPagination(
            ApiResponse.ApiResponseBuilder<T> builder,
            int page, int size, long total, String sortBy, String sortDir) {

        PaginationInfo pagination = PaginationInfoFactory.of(page, size, total, sortBy, sortDir);
        return builder.pagination(pagination);
    }

    public static <T> ApiResponse.ApiResponseBuilder<T> withProcessingTime(
            ApiResponse.ApiResponseBuilder<T> builder,
            long startTimeMs) {

        long processingTime = System.currentTimeMillis() - startTimeMs;
        return builder.processingTimeMs(processingTime);
    }

    public static <T> ApiResponse.ApiResponseBuilder<T> withMetadata(
            ApiResponse.ApiResponseBuilder<T> builder,
            String requestId, String serviceName, String path) {

        return builder
                .requestId(requestId)
                .serviceName(serviceName)
                .path(path);
    }

}
