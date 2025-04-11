package com.example.demo1.post.dto.request;

import com.example.demo1.post.entity.PostStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostCreateReq {

    @Schema(description = "유저ID (NOT NULL)", example = "1")
    @NotNull(message = "UserId는 반드시 지정되어야 합니다.")
    private Long userId;

    @Schema(description = "게시물 제목 (NOT BLANK)", example = "어린왕자")
    @NotBlank(message = "게시물 제목은 빈칸이면 안됩니다.")
    private String title;

    @Schema(description = "게시물 내용 (NOT NULL)", example = "어린왕자는 오늘도 행복합니다.")
    @NotBlank(message = "게시물 내용은 빈칸이면 안됩니다.")
    private String content;

    @Schema(description = "게시물 상태 (PUBLIC 또는 PRIVATE) (NOT NULL)", example = "PUBLIC")
    @NotNull(message = "게시물 상태는 반드시 지정되어야 합니다.")
    private PostStatus status;
}
