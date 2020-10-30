package com.xyz.springboot.demo1.controller;

import com.xyz.springboot.demo1.message.user.User;
import com.xyz.springboot.demo1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author xuanyz
 * @title: UserController
 * @projectName demo1
 * @date 2020/9/25 10:30
 * @description: 用户管理控制层
 * @ModifyRecord： 修改日期: 修改内容
 */
@Api(tags = "UserController接口")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
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
