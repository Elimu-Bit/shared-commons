package com.skillforge.Shared_Commons.response;

public class PaginationInfoFactory {

    private PaginationInfoFactory() {
        // Utility class
    }

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
