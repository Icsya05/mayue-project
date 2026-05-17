package com.example.codeleapbackend.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.codeleapbackend.*.mapper")
public class MybatisConfig {
}