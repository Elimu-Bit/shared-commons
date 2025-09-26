package com.skillforge.Shared_Commons.exceptions;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class ServiceException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus status;
    private final LocalDateTime timestamp;
    private final Map<String, Object> details;
    private final String serviceName;

    private ServiceException(String message, String errorCode, HttpStatus status, String serviceName) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
        this.serviceName = serviceName;
        this.timestamp = LocalDateTime.now();
        this.details = new HashMap<>();
    }

    private ServiceException(String message, String errorCode, HttpStatus status, String serviceName, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.status = status;
        this.serviceName = serviceName;
        this.timestamp = LocalDateTime.now();
        this.details = new HashMap<>();
    }

    // Contextual details
    public ServiceException addDetail(String key, Object value) {
        this.details.put(key, value);
        return this;
    }

    public ServiceException addDetails(Map<String, Object> details) {
        this.details.putAll(details);
        return this;
    }

    // Builder pattern for flexible creation

    public static ServiceExceptionBuilder builder() {
        return new ServiceExceptionBuilder();
    }

    public static class ServiceExceptionBuilder {

        private String message;
        private String errorCode;
        private HttpStatus httpStatus;
        private String serviceName;
        private Throwable cause;
        private Map<String, Object> details = new HashMap<>();

        public ServiceExceptionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ServiceExceptionBuilder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ServiceExceptionBuilder status(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ServiceExceptionBuilder serviceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public ServiceExceptionBuilder cause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        public ServiceExceptionBuilder detail(String key, Object value) {
            this.details.put(key, value);
            return this;
        }

        public ServiceExceptionBuilder details(Map<String, Object> details) {
            this.details.putAll(details);
            return this;
        }

        public ServiceException build() {
            ServiceException exception = cause != null
                    ? new ServiceException(message, errorCode, httpStatus, serviceName, cause)
                    : new ServiceException(message, errorCode, httpStatus, serviceName);

            exception.addDetails(details);
            return exception;
        }

    }

    // Quick factory methods for common HTTP statuses
    public static ServiceException badRequest(String message, String errorCode) {
        return builder()
                .message(message)
                .errorCode(errorCode)
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    public static ServiceException unauthorized(String message) {
        return builder()
                .message(message)
                .errorCode("UNAUTHORIZED")
                .status(HttpStatus.UNAUTHORIZED)
                .build();
    }

    public static ServiceException forbidden(String message) {
        return builder()
                .message(message)
                .errorCode("FORBIDDEN")
                .status(HttpStatus.FORBIDDEN)
                .build();
    }

    public static ServiceException notFound(String message) {
        return builder()
                .message(message)
                .errorCode("NOT_FOUND")
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    public static ServiceException conflict(String message) {
        return builder()
                .message(message)
                .errorCode("CONFLICT")
                .status(HttpStatus.CONFLICT)
                .build();
    }

    public static ServiceException unprocessableEntity(String message, String errorCode) {
        return builder()
                .message(message)
                .errorCode(errorCode)
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .build();
    }

    public static ServiceException internalServerError(String message) {
        return builder()
                .message(message)
                .errorCode("INTERNAL_SERVER_ERROR")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    public static ServiceException badGateway(String message) {
        return builder()
                .message(message)
                .errorCode("BAD_GATEWAY")
                .status(HttpStatus.BAD_GATEWAY)
                .build();
    }

    // Resource-specific factory methods
    public static ServiceException resourceNotFound(String resourceType, Object resourceId) {
        return builder()
                .message(String.format("%s not found with id: %s", resourceType, resourceId))
                .errorCode("RESOURCE_NOT_FOUND")
                .status(HttpStatus.NOT_FOUND)
                .detail("resourceType", resourceType)
                .detail("resourceId", resourceId)
                .build();
    }

    public static ServiceException validationError(String message) {
        return builder()
                .message(message)
                .errorCode("VALIDATION_ERROR")
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    public static ServiceException validationError(String message, Map<String, String> fieldErrors) {
        return builder()
                .message(message)
                .errorCode("VALIDATION_ERROR")
                .status(HttpStatus.BAD_REQUEST)
                .detail("fieldErrors", fieldErrors)
                .build();
    }

    public static ServiceException businessRuleViolation(String message, String ruleCode) {
        return builder()
                .message(message)
                .errorCode(ruleCode)
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .build();
    }

    public static ServiceException externalServiceError(String serviceName, String message) {
        return builder()
                .message(String.format("External service '%s' error: %s", serviceName, message))
                .errorCode("EXTERNAL_SERVICE_ERROR")
                .status(HttpStatus.BAD_GATEWAY)
                .detail("externalService", serviceName)
                .build();
    }

}