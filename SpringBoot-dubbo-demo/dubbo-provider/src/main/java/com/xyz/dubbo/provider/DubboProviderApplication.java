package com.xyz.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuanyz
 * @title: DubboProviderApplication
 * @projectName springBoot-Demo
 * @date 2020/11/16 14:45
 * @description: TODO
 * @ModifyRecord： 修改日期: 修改内容
 */
@SpringBootApplication
@EnableDubbo
public class DubboProviderApplication {

    public static void main(String[] args){
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
