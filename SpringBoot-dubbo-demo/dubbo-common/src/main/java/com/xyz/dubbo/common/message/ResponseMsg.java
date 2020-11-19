package com.xyz.dubbo.common.message;

import lombok.Getter;

/**
 * @author xuanyz
 * @title: ResponseMsg
 * @projectName demo1
 * @date 2020/9/28 11:48
 * @description: 全局响应封装类
 * @ModifyRecord： 修改日期: 修改内容
 */
@Getter
public class ResponseMsg<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResponseMsg(T data) {
        this(ResponseCode.SUCCESS, data);
    }

    public ResponseMsg(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }
}
