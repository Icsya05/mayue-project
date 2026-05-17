package com.example.codeleapbackend.user.mapper;

import com.example.codeleapbackend.user.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User selectByUsername(@Param("username")String  username);
    void insert(@Param("username")String username,@Param("password")String password);
    void resetPassword(@Param("username")String username,@Param("password")String password);
}
