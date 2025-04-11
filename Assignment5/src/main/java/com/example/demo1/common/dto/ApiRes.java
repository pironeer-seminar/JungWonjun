package com.example.demo1.common.dto;

import com.example.demo1.common.exception.BaseException;
import com.example.demo1.common.type.ErrorType;
import com.example.demo1.common.type.SuccessType;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

public record ApiRes<T> (
        Integer status, String code, String message, @JsonInclude(JsonInclude.Include.NON_NULL) T data) {

    // 응답 데이터 없는 버전
    public static ApiRes<?> success(SuccessType successType) {
        return new ApiRes<>(HttpStatus.OK.value(), successType.getCode(), successType.getMessage(), null);
    }

    // 응답 데이터 있는 버전
    public static <T> ApiRes<T> success(SuccessType successType, T data) {
        return new ApiRes<>(HttpStatus.OK.value(), successType.getCode(), successType.getMessage(), data);
    }

    public static ApiRes<?> fail(ErrorType errorType, HttpStatus Status) {
        return new ApiRes<>(Status.value(), errorType.getCode(), errorType.getMessage(), null);
    }

    public static <T> ApiRes<T> fail(ErrorType errorType, HttpStatus Status, T data) {
        return new ApiRes<>(Status.value(), errorType.getCode(), errorType.getMessage(), data);
    }

    public static <T> ApiRes<T> fail(BaseException baseException) {
        ErrorType errorType = baseException.getErrorType();
        return new ApiRes<>(
                baseException.getHttpStatusCode(),
                errorType.getCode(),
                errorType.getMessage(),
                null
        );
    }
}
