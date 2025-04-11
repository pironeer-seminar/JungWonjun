package com.example.demo1.common.dto;

import com.example.demo1.common.exception.BaseException;
import com.example.demo1.common.type.ErrorType;
import com.example.demo1.common.type.SuccessType;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

public record ApiRes<T> (
        @Schema(description = "HTTP 상태 코드", example = "200")
        Integer status,

        @Schema(description = "성공 또는 에러 코드", example = "POST_1")
        String code,

        @Schema(description = "응답 메세지", example = "게시글 생성에 성공하였습니다.")
        String message,

        @Schema(description = "실제 응답 데이터")
        @JsonInclude(JsonInclude.Include.NON_NULL) T data) {

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
