package com.xyz.dubbo.common.utils;

import com.xyz.dubbo.common.message.ResponseCode;
import com.xyz.dubbo.common.message.ResponseMsg;
import com.xyz.dubbo.common.message.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * @author xuanyz
 * @title: ExceptionControllerAdvice
 * @projectName demo1
 * @date 2020/9/28 11:07
 * @description: 全局异常处理类：全局异常、自定义异常、校验参数异常、类型转换异常、404 not found、405 method not supported
 * @ModifyRecord： 修改日期: 修改内容
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.xyz.dubbo.consumer.controller"})
public class ExceptionControllerAdvice {

    /**
     * 全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseMsg<String> exceptionHandler(Exception e) {
        return new ResponseMsg<>(ResponseCode.ERROR, e.getMessage());
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(APIException.class)
    public ResponseMsg<String> APIExceptionHandler(APIException e) {
        return new ResponseMsg<>(ResponseCode.FAILED, e.getMsg());
    }

    /**
     * 校验参数异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseMsg<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResponseMsg<>(ResponseCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    /**
     * 400 请求参数封装到bean时 类型转换异常
     * <p>
     * 400 (Bad Request)
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class})
    public ResponseMsg<String> handleRequestParamFormatError(Exception ex) {
        log.error("handleRequestParamFormatError() bad request ex:{}", ex.getLocalizedMessage());
        return new ResponseMsg<>(ResponseCode.PARAM_FORMAT, ex.getLocalizedMessage());
    }

    /**
     * 404 (Not Found)
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseMsg<String> handleNoHandlerFoundException(NoHandlerFoundException ex, WebRequest request) {
        log.error("handleNoHandlerFoundException() {}{}{} ", request, " exception message:", ex.getLocalizedMessage());
        return new ResponseMsg<>(ResponseCode.FOUND_FAILED, ex.getLocalizedMessage());

    }

    /**
     * 405 (Method Not Allowed)
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseMsg<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.error("handleHttpRequestMethodNotSupportedException() request Method Not Allowed(405) exception message:{}", ex.getLocalizedMessage());
        return new ResponseMsg<>(
                ResponseCode.SUPPORTED_FAILED, ex.getLocalizedMessage());
    }

}
