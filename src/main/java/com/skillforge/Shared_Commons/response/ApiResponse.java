package com.skillforge.Shared_Commons.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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


}
