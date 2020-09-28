package com.xyz.springboot.demo1.message.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author xuanyz
 * @title: User
 * @projectName demo1
 * @date 2020/9/25 10:31
 * @description: 用户请求message
 * @ModifyRecord： 修改日期: 修改内容
 */
@ApiModel("用户接口请求对象")
@Data
public class User {
    @ApiModelProperty(required = true, notes = "用户id", example = "1001")
    @NotNull(message = "用户id不能为空")
    private Long id;

    @ApiModelProperty(required = true, notes = "用户账号", example = "abc001")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String account;

    @ApiModelProperty(required = true, notes = "用户密码", example = "123456")
    @NotBlank(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;

    @ApiModelProperty(required = true, notes = "用户邮箱", example = "xxxx@qq.com")
    @NotBlank(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}