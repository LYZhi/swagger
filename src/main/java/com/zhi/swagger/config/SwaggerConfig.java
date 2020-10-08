package com.zhi.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("a");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("b");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("c");
    }

    //配置了swagger的docket 的bean实例
    @Bean
    public Docket docket(Environment environment) {

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过 environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组
                .groupName("zhi")
                //是否启用swagger 默认true，启用
                .enable(flag)
                .select()
                //配置要扫描接口的方式
                //basePackage 指定要扫描的包
                //any 扫描全部
                //none 不扫描
                //withClassAnnotation 扫描类上的注解 参数是一个注解的反射对象
                //withMethodAnnotation 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.zhi.swagger.controller"))
                //paths 过滤什么路径
                .paths(PathSelectors.ant("./zhi/**"))
                .build();

    }

    //配置swagger信息=APiInfo
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("lyzz", "","123");
        return new ApiInfo(
                "swagger文档",
                "Api Documentation",
                "v1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
