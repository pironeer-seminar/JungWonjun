package com.pironeer.Assignment4.dto.request;

import lombok.Getter;

@Getter
public class CommentCreateReq {
    private Long postId;
    private Long userId;
    private String content;
}