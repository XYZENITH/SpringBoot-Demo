package com.xyz.springboot.demo1.message;

import lombok.Getter;

/**
 * @author xuanyz
 * @title: ResponseCode
 * @projectName demo1
 * @date 2020/9/28 14:46
 * @description: 自定义响应码
 * @ModifyRecord： 修改日期: 修改内容
 */
@Getter
public enum ResponseCode {
    SUCCESS(1000, "操作成功"),

    FAILED(8999, "操作失败"),

    VALIDATE_FAILED(2002, "参数校验失败"),

    PARAM_FORMAT(2400, "类型转换失败"),

    FOUND_FAILED(2404, "资源加载失败"),

    SUPPORTED_FAILED(2405, "操作失败"),

    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
