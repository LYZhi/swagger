package com.zhi.swagger.controller;

import com.zhi.swagger.pojo.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11215
 */


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //只要我们的接口中，返回值中存在实体类，他就会被扫描到swagger中
    @PostMapping("/user")
    public User user() {
        return new User();
    }

    //给接口加注释，放在方法上
    @ApiOperation("hello的接口")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }
    @ApiOperation("post测试")
    @GetMapping("/post")
    public User post(User user){
        return user;
    }
}
