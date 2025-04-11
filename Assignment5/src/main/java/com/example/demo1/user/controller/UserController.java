package com.example.demo1.user.controller;

import com.example.demo1.user.dto.request.UserCreateReq;
import com.example.demo1.user.entity.User;
import com.example.demo1.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    @Operation(
            summary = "유저 생성 API",
            description = "유저를 생성합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 유저 생성"),
                    @ApiResponse(responseCode = "400", description = "잘못된 입력값"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    public Long create(@RequestBody UserCreateReq req) {
        return userService.create(req);
    }

}
