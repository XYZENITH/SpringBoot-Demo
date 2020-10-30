package com.xyz.springboot.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xuanyz
 * @title: Demo1Application
 * @projectName demo1
 * @date 2020/9/25 10:29
 * @description: Spring Boot 启动类
 * @ModifyRecord： 修改日期: 修改内容
 */
@Slf4j
@SpringBootApplication
public class MybatisPlusApplication {

    public static void main(String[] args) throws UnknownHostException {
        long beginTime = System.currentTimeMillis();
        ConfigurableApplicationContext application = SpringApplication.run(MybatisPlusApplication.class, args);
        long endTime = System.currentTimeMillis();
        log.error("-----------启动完毕---------;启动耗时(s):"+((endTime-beginTime)/1000));
        Environment env = application.getEnvironment();
        String host= InetAddress.getLocalHost().getHostAddress();
        String port=env.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t"+
                        "Doc: \thttp://{}:{}/doc.html\n\t"+
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                host,port,
                host,port);
    }


}
