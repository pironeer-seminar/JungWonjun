package com.pironeer.Assignment4.dto.response;

import lombok.Getter;

@Getter
public class CommentRes {
    private Long postId;
    private Long userId;
    private String content;
}