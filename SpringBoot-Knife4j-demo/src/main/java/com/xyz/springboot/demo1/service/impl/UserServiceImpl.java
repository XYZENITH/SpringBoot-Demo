package com.xyz.springboot.demo1.service.impl;

import com.xyz.springboot.demo1.message.user.User;
import com.xyz.springboot.demo1.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author xuanyz
 * @title: UserServiceImpl
 * @projectName demo1
 * @date 2020/9/25 10:50
 * @description: 用户管理服务实现类
 * @ModifyRecord： 修改日期: 修改内容
 */
@Service
public class UserServiceImpl implements UserService {

    public String addUser(User user) {
        return "success";
    }

    @Override
    public User getUser() {
        User user = new User();
        user.setId(1001L);
        user.setAccount("123456");
        user.setPassword("123456");
        user.setEmail("123@qq.com");
        return user;
    }
}

