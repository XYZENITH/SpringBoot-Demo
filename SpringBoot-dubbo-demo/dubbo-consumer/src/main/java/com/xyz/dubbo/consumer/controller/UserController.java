package com.xyz.dubbo.consumer.controller;

import com.xyz.dubbo.common.UserService;
import com.xyz.dubbo.common.message.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author xuanyz
 * @title: UserController
 * @projectName springBoot-Demo
 * @date 2020/11/16 15:11
 * @description: TODO
 * @ModifyRecord： 修改日期: 修改内容
 */
@Api(tags = "UserController接口")
@RestController
@RequestMapping("user")
public class UserController {

    @DubboReference
    private UserService userService;


    @ApiOperation(value = "post请求调用示例", notes = "添加用户", httpMethod = "POST")
    @PostMapping("/addUser")
    public String addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "get请求调用示例", notes = "获取用户信息", httpMethod = "GET")
    @GetMapping("/getUser")
    public User getUser() {
        return userService.getUser();
    }
}
