package com.example.demo1.user.controller;

import com.example.demo1.user.dto.request.UserCreateReq;
import com.example.demo1.user.entity.User;
import com.example.demo1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public Long create(@RequestBody UserCreateReq req) {
        return userService.create(req);
    }

}
