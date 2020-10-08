package com.zhi.vo.req;

import lombok.Data;

/**
 * @author LYZhi
 * @date 2020/10/8 13:29
 */
@Data
public class UpdateUserReqVO {

    private String id;
    private String username;
    private String password;
    private String phone;
    private String depId;
    private String realName;
    private String nickName;
    private String email;
    private Integer status;
    private Integer sex;

}
