package com.zhi.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LYZhi
 * @date 2020/10/8 14:45
 */

//用在类上，对类进行说明，用于实体类中的参数则表示参数的接收说明

@Data
@ApiModel(value = "com.zhi.vo.req.SwaggerReqVO", description = "swagger接收用户数据")
public class SwaggerReqVO {
    //对属性进行描述
    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}
