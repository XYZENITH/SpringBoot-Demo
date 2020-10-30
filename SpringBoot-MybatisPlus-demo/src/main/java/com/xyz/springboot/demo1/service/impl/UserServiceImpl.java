package com.xyz.springboot.demo1.service.impl;

import com.xyz.springboot.demo1.domain.User;
import com.xyz.springboot.demo1.repository.UserMapper;
import com.xyz.springboot.demo1.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author xuanyz
* @title: 系统用户服务实现类
* @projectName 
* @date 2020-10-30
* @description: 系统用户服务服务实现类
* @ModifyRecord： 修改日期: 修改内容
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
