package com.example.codeleapbackend.common; // 已经自动匹配你项目的包名

import lombok.Data;

@Data // 自动生成getter、setter、toString方法
public class Result<T> {
    // 状态码：200=成功，500=失败
    private Integer code;
    // 提示信息：比如"登录成功"、"用户名不存在"
    private String msg;
    // 返回的数据：可以是用户信息、任务列表等任何类型
    private T data;

    // 成功的静态方法：接口成功时调用这个方法返回结果
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    // 失败的静态方法：接口失败时调用这个方法返回结果
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }
}
