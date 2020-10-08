package com.zhi.service;

import com.zhi.entity.SysUser;
import com.zhi.vo.req.RegisterReqVO;

/**
 * @author LYZhi
 * @date 2020/10/4 20:33
 */
public interface UserService {
    SysUser getUserInfo(String id);

    String register(RegisterReqVO registerReqVO);
}
