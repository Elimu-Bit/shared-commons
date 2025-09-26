package com.skillforge.Shared_Commons.response;

import java.time.LocalDateTime;
import java.util.List;

public class ListResponseFactory {

    private ListResponseFactory() {
        // Utility class
    }

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
                .pagination(PaginationInfoFactory.of(page, size, total, null, null))
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ListResponse<T> empty(int page, int size) {
        return ListResponse.<T>builder()
                .success(true)
                .data(List.of())
                .pagination(PaginationInfoFactory.of(page, size, 0L, null, null))
                .timestamp(LocalDateTime.now())
                .build();
    }


}
