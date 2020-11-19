package com.xyz.dubbo.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.dubbo.common.message.ResponseMsg;
import com.xyz.dubbo.common.message.exception.APIException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author xuanyz
 * @title: ResponseControllerAdvice
 * @projectName demo1
 * @date 2020/9/28 15:14
 * @description: 全局响应类
 * @ModifyRecord： 修改日期: 修改内容
 */
@RestControllerAdvice(basePackages = {"com.xyz.dubbo.consumer.controller"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
        return !methodParameter.getGenericParameterType().equals(ResponseMsg.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //String类型不能直接封装，需要进行处理
        if (methodParameter.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //把数据封装在ResultVO里，再转化为json字符串返回给前端
                return objectMapper.writeValueAsString(new ResponseMsg<>(o));
            }catch (JsonProcessingException e){
                throw new APIException("返回String类型错误");
            }
        }
        // 将原本的数据包装在ResultVO里
        return new ResponseMsg<>(o);
    }
}
