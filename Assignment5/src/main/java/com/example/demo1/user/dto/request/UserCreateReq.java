package com.example.demo1.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserCreateReq {

    @NotBlank
    private String name;
}
