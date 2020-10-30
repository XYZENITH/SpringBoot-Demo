package com.xyz.springboot.demo1.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import com.xyz.springboot.demo1.message.page.BasePageMsg;
import com.xyz.springboot.demo1.service.UserService;
import com.xyz.springboot.demo1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author xuanyz
* @title: 系统用户控制器
* @projectName 
* @date 2020-10-30
* @description: 系统用户控制器
* @ModifyRecord： 修改日期: 修改内容
*/
@RestController
@RequestMapping("/user")
@Api(tags = "UserActionController接口")
public class UserAction {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "分页查询", notes = "User分页查询", httpMethod = "GET")
    @GetMapping(value = "/get_Users")
    public Page<User> list(@Valid @RequestBody BasePageMsg basePageMsg) {
       Page<User> aPage = userService.page(new Page<>(basePageMsg.getCurrent(), basePageMsg.getPageSize()));
        return aPage;
    }

    @ApiOperation(value = "查询一条数据", notes = "查询User", httpMethod = "GET")
    @GetMapping(value = "/get_User/{id}")
    public User getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "新建一条数据", notes = "新建User", httpMethod = "POST")
    @PostMapping(value = "/create_User")
    public String create(@Valid @RequestBody User params) {
        userService.save(params);
        return "created successfully";
    }

    @ApiOperation(value = "删除一条数据", notes = "删除User", httpMethod = "POST")
    @PostMapping(value = "/delete_User/{id}")
    public String delete(@PathVariable("id") String id) {
        userService.removeById(id);
        return "deleted successfully";
    }

    @ApiOperation(value = "更新一条数据", notes = "更新User", httpMethod = "POST")
    @PostMapping(value = "/update_User")
    public String update(@Valid @RequestBody User params) {
        userService.updateById(params);
        return "updated successfully";
    }
}
