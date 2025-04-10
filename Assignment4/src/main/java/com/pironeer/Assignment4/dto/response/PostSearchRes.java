package com.pironeer.Assignment4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostSearchRes {
    private Long userId;
    private Long postId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentWithRes> comments;
}