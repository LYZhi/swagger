package com.zhi.web.controller;


import com.zhi.vo.req.SwaggerReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11215
 */


@RestController
//用在类上，说明该类的作用，可以标记一个controller类作为swagger文档资源
@Api(tags = "swagger接口",description ="swagger" )
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //给接口加注释，放在方法上
    @ApiOperation("swagger的测试——testSwagger接口")
    @PostMapping("/testSwagger")
    public SwaggerReqVO testSwagger(@RequestBody SwaggerReqVO swaggerReqVO) {
        return swaggerReqVO;
    }

}
