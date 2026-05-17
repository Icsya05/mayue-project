package com.example.codeleapbackend.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 告诉SpringBoot：这是一个全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕获所有类型的异常
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        // 把详细错误信息打印到控制台，方便我们找bug
        e.printStackTrace();
        // 返回统一格式的错误结果
        return Result.error("系统异常：" + e.getMessage());
    }
}
