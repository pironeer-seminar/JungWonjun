package com.example.demo1.post.dto.request;

import com.example.demo1.post.entity.PostStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostCreateReq {

    @NotNull(message = "UserId는 반드시 지정되어야 합니다.")
    private Long userId;

    @NotBlank(message = "게시물 제목은 빈칸이면 안됩니다.")
    private String title;

    @NotBlank(message = "게시물 내용은 빈칸이면 안됩니다.")
    private String content;

    @NotNull(message = "게시물 상태는 반드시 지정되어야 합니다.")
    private PostStatus status;
}
