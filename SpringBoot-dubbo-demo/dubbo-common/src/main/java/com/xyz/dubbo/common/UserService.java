package com.xyz.dubbo.common;

import com.xyz.dubbo.common.message.user.User;

/**
 * @author xuanyz
 * @title: UserService
 * @projectName springBoot-Demo
 * @date 2020/11/16 15:10
 * @description: TODO
 * @ModifyRecord： 修改日期: 修改内容
 */
public interface UserService {
    String addUser(User user);

    User getUser();
}
