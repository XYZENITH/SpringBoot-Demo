package com.xyz.springboot.demo1.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xuanyz
 * @title: SwaggerConfig
 * @projectName demo1
 * @date 2020/9/25 10:29
 * @description: knife4j配置类
 * @ModifyRecord： 修改日期: 修改内容
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(value = {BeanValidatorPluginsConfiguration.class})  //一些校验，不使用Knife4j不加该注解
public class Knife4jConfig {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("group")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.xyz.springboot.demo1.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SpringBoot Demo 奥力给~~~！！！")
                .description("SpringBoot Demo RESTful APIs")
                .termsOfServiceUrl("http://localhost/")
                .contact("xuanyz@qq.com")
                .version("1.0")
                .build();
    }

}
