package com.xyz.springboot.demo1.repository;

import com.xyz.springboot.demo1.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xuanyz
* @title: 系统用户Mapper 接口
* @projectName 
* @date 2020-10-30
* @description: 系统用户Mapper 接口
* @ModifyRecord： 修改日期: 修改内容
*/
public interface UserMapper extends BaseMapper<User> {

}
