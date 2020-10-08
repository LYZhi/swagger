package com.zhi.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LYZhi
 * @date 2020/9/24 11:17
 */
@SpringBootApplication(scanBasePackages = "com.zhi")
@MapperScan("com.zhi.mapper")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
