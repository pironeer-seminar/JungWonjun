package com.example.demo1.post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostSearchRes {

    @Schema(description = "유저 ID", example = "1")
    private Long userId;

    @Schema(description = "게시물 ID", example = "1")
    private Long postId;

    @Schema(description = "게시물 제목", example = "어린왕자")
    private String title;

    @Schema(description = "게시물 내용", example = "그는 좋은 사람이었습니다.")
    private String content;

    @Schema(description = "생성시간", example = "2025-04-11T13:49:12.802Z")
    private LocalDateTime createdAt;
}
