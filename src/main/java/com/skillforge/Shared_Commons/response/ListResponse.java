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
}
