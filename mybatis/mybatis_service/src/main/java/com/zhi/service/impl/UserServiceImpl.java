package com.zhi.service.impl;

import com.zhi.entity.SysUser;
import com.zhi.mapper.SysUserMapper;
import com.zhi.service.UserService;
import com.zhi.utils.PasswordUtils;
import com.zhi.vo.req.RegisterReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author LYZhi
 * @date 2020/10/4 20:34
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserInfo(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public String register(RegisterReqVO registerReqVO) {
        SysUser sysUser = new SysUser();
        //BeanUtils.copyProperties("要转换的类", "转换后的类");
        BeanUtils.copyProperties(registerReqVO, sysUser);
        sysUser.setCreateTime(new Date());
        sysUser.setId(UUID.randomUUID().toString());
        String salt = PasswordUtils.salt();
        String encode = PasswordUtils.md5(registerReqVO.getPassword() + salt);
        sysUser.setPassword(encode);
        sysUser.setSalt(salt);
        int i = sysUserMapper.insertSelective(sysUser);
        if (i != 1) {
            return "注册失败";
        }
        return "注册成功";

    }
}
