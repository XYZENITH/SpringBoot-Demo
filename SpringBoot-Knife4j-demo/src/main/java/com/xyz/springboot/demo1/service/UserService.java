package com.xyz.springboot.demo1.service;

import com.xyz.springboot.demo1.message.user.User;

/**
 * @author xuanyz
 * @title: UserService
 * @projectName demo1
 * @date 2020/9/25 10:51
 * @description: 用户管理服务接口
 * @ModifyRecord： 修改日期: 修改内容
 */
public interface UserService {
    String addUser(User user);

    User getUser();
}
