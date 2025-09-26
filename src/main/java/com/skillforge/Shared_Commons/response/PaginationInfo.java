package com.skillforge.Shared_Commons.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInfo {

    private int currentPage;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean hasNext;
    private boolean hasPrevious;
    private String sortBy;
    private String sortDirection;

    // Helper methods
    public static PaginationInfo of(int page, int size, long total, String sortBy, String sortDirection) {
        int totalPages = (int) Math.ceil((double) total / size);

        return PaginationInfo.builder()
                .currentPage(page)
                .pageSize(size)
                .totalElements(total)
                .totalPages(totalPages)
                .hasNext(page < totalPages - 1)
                .hasPrevious(page > 0)
                .sortBy(sortBy)
                .sortDirection(sortDirection)
                .build();
    }

}
