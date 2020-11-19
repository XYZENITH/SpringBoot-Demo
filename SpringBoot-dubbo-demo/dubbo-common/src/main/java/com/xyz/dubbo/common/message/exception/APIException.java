package com.xyz.dubbo.common.message.exception;

import lombok.Getter;

/**
 * @author xuanyz
 * @title: APIException
 * @projectName demo1
 * @date 2020/9/28 11:25
 * @description: 自定义异常类
 * @ModifyRecord： 修改日期: 修改内容
 */
@Getter
public class APIException extends RuntimeException{
    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
