package com.example.codeleapbackend.user.service.impl;

import com.example.codeleapbackend.common.ServiceException;
import com.example.codeleapbackend.common.StatusCode;
import com.example.codeleapbackend.user.mapper.UserMapper;
import com.example.codeleapbackend.user.pojo.dto.LoginParam;
import com.example.codeleapbackend.user.pojo.entity.User;
import com.example.codeleapbackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void register(LoginParam loginParam) {
        User user=userMapper.selectByUsername(loginParam.getUserName());
        if(user!=null){
            throw new ServiceException(StatusCode.USERNAME_ALREADY_EXISTS);
        }
        else{
            userMapper.insert(loginParam.getUserName(),loginParam.getPassword());
        }
    }
    @Override
    public User login(LoginParam loginParam){
        if(loginParam.getUserName()==null){
            throw new ServiceException(StatusCode.USERNAME_ERROR);
        }
        User user=userMapper.selectByUsername(loginParam.getUserName());
        if(user==null){
            throw new ServiceException(StatusCode.DATA_UNEXISTS);
        }
        else if(!loginParam.getPassword().equals(user.getPassword())){
            throw new ServiceException(StatusCode.PASSWORD_ERROR);
        }
        else{
            return user;
        }
    }
    @Override
    public void resetPassword(LoginParam loginParam){
        if(loginParam.getUserName()==null){
            throw new ServiceException(StatusCode.USERNAME_ERROR);
        }
        User user= userMapper.selectByUsername(loginParam.getUserName());
        if(user==null){
            throw new ServiceException(StatusCode.DATA_UNEXISTS);
        }
        if(loginParam.getPassword().equals(user.getPassword())){
            throw new ServiceException(StatusCode.PASSWORD_SAME);
        }else{
            userMapper.resetPassword(loginParam.getUserName(),loginParam.getPassword());
        }
    }

}
