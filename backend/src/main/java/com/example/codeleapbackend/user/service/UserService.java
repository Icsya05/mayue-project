package com.example.codeleapbackend.user.service;

import com.example.codeleapbackend.user.pojo.dto.LoginParam;
import com.example.codeleapbackend.user.pojo.entity.User;


public interface UserService {
    public void register(LoginParam loginParam);
    public User login(LoginParam loginParam);
    public void resetPassword(LoginParam loginParam);
}
