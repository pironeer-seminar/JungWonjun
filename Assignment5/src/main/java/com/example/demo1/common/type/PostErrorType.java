package com.example.demo1.common.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PostErrorType implements ErrorType {

    NOT_FOUND("POST_1", "조회된 게시물이 없습니다.");

    public final String code;
    public final String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
