package com.zhi.vo.req;

import lombok.Data;

/**
 * @author LYZhi
 * @date 2020/10/7 15:33
 */
@Data
public class RegisterReqVO {
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String createWhere;
    private String email;
    private String nickName;
}
