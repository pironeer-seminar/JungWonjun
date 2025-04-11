package com.example.demo1.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserCreateReq {

    @Schema(description = "유저 이름 (NOT NULL)", example = "PUBLIC")
    @NotNull(message = "게시물 상태는 반드시 지정되어야 합니다.")
    private String name;
}
