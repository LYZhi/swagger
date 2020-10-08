package com.zhi.web.controller;

import com.zhi.entity.SysUser;
import com.zhi.service.UserService;
import com.zhi.vo.req.RegisterReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LYZhi
 * @date 2020/10/4 20:36
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public SysUser getUserInfo(@PathVariable("id") String id){
        return userService.getUserInfo(id);
    }


    @GetMapping("/getUser")
    public SysUser getUserDetail(@RequestParam(required = false) String id) {

        return userService.getUserInfo(id);
    }

    @PostMapping("/user")
    public String insertUser(@RequestBody RegisterReqVO registerReqVO){
        return userService.register(registerReqVO);
    }
}
