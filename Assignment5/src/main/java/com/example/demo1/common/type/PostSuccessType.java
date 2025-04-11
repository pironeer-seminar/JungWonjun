package com.example.demo1.common.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PostSuccessType implements SuccessType {

    GET_ALL("POST_1", "게시글 목록 조회에 성공하였습니다."),
    CREATE("POST_2", "게시글 생성에 성공하였습니다.");

    private final String code;
    private final String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}