package com.example.demo1.common.exception;

import com.example.demo1.common.dto.ApiRes;
import com.example.demo1.common.type.CommonErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiRes<?>> handlerIllegalArgumentException(final IllegalArgumentException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                ApiRes.fail(CommonErrorType.INTERNAL_SERVER, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiRes<?>> handleCustomException(final BaseException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ApiRes.fail(ex), ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiRes<?>> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        log.error(ex.getMessage());
        Map<String, String> errorDetails = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorDetails.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(
                ApiRes.fail(CommonErrorType.INVALID_INPUT, HttpStatus.BAD_REQUEST, errorDetails),
                HttpStatus.BAD_REQUEST
        );
    }
}