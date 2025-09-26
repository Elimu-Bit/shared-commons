package com.skillforge.Shared_Commons.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListResponse<T> {

    private boolean success;
    private String message;
    private List<T> data;
    private PaginationInfo pagination;
    private LocalDateTime timestamp;
    private String requestId;
    private String serviceName;
    private Long processingTimeMs;

    // Search/filter metadata
    private String searchQuery;
    private Map<String, Object> appliedFilters;
    private Map<String, Object> availableFilters;

    // Aggregation data (for analytics)
    private Map<String, Object> aggregations;

    public static <T> ListResponse<T> of(List<T> data, PaginationInfo pagination) {
        return ListResponse.<T>builder()
                .success(true)
                .data(data)
                .pagination(pagination)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ListResponse<T> of(List<T> data, int page, int size, long total) {
        return ListResponse.<T>builder()
                .success(true)
                .data(data)
                .pagination(PaginationInfo.of(page, size, total, null, null))
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ListResponse<T> empty(int page, int size) {
        return ListResponse.<T>builder()
                .success(true)
                .data(List.of())
                .pagination(PaginationInfo.of(page, size, 0L, null, null))
                .timestamp(LocalDateTime.now())
                .build();
    }

}
