package com.xyz.dubbo.provider.impl;

import com.xyz.dubbo.common.UserService;
import com.xyz.dubbo.common.message.user.User;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xuanyz
 * @title: UserServiceImpl
 * @projectName springBoot-Demo
 * @date 2020/11/16 15:11
 * @description: TODO
 * @ModifyRecord： 修改日期: 修改内容
 */
@DubboService
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
