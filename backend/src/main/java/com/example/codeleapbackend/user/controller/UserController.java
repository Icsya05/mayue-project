package com.example.codeleapbackend.user.controller;

import com.example.codeleapbackend.common.Result;
import com.example.codeleapbackend.user.pojo.dto.LoginParam;
import com.example.codeleapbackend.user.pojo.entity.User;
import com.example.codeleapbackend.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("v1/User")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
    public Result register(LoginParam loginParam){
        userService.register(loginParam);
        return Result.ok();
    }
    @PostMapping("login")
    public Result login(LoginParam loginParam){
        User user=userService.login(loginParam);
        return Result.ok(user);
    }
    @PostMapping("resetPassword")
    public Result resetPassword(LoginParam loginParam){
        userService.resetPassword(loginParam);
        return Result.ok();
    }
}
