package com.xyz.springboot.demo1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuanyz
 * @title: MybatisPlusConfig
 * @projectName springBoot-mybatisPlus-knife4j
 * @date 2020/10/30 14:37
 * @description: TODO
 * @ModifyRecord： 修改日期: 修改内容
 */
@Configuration
@MapperScan("com.xyz.springboot.demo1.repository")
public class MybatisPlusConfig {
}