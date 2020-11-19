package com.xyz.dubbo.consumer;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xuanyz
 * @title: DubboConsumerApplication
 * @projectName springBoot-Demo
 * @date 2020/11/16 15:02
 * @description: TODO
 * @ModifyRecord： 修改日期: 修改内容
 */
@EnableDubbo
@SpringBootApplication(scanBasePackages = "com.xyz")
public class DubboConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(DubboConsumerApplication.class, args);
    }
}
