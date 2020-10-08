package com.zhi.web.controller;

import com.zhi.entity.SysUser;
import com.zhi.service.UserService;
import com.zhi.vo.req.RegisterReqVO;
import com.zhi.vo.req.UpdateUserReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public SysUser getUserInfo(@PathVariable("id") String id) {
        return userService.getUserInfo(id);
    }


    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户信息接口")
    //参数说明，是否必填
    public SysUser getUserDetail(@ApiParam(value = "用户id", required = true) @RequestParam String id,
                                 HttpServletRequest request) {
        System.out.println(request.getHeader("token"));
        return userService.getUserInfo(id);
    }

    @PostMapping("/user")
    public String insertUser(@RequestBody RegisterReqVO registerReqVO) {
        return userService.register(registerReqVO);
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody UpdateUserReqVO updateUserReqVO) {
        return userService.updateUserInfo(updateUserReqVO);
    }

    @DeleteMapping("/user/{id}")
    public String deletedUser(@PathVariable("id") String id) {
        return userService.deleted(id);
    }
}
