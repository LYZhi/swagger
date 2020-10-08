package com.zhi.service.impl;

import com.zhi.entity.SysUser;
import com.zhi.mapper.SysUserMapper;
import com.zhi.service.UserService;
import com.zhi.utils.PasswordUtils;
import com.zhi.vo.req.RegisterReqVO;
import com.zhi.vo.req.UpdateUserReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
        //对密码进行加密
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

    @Override
    //用户提交密码修改操作
    //事务在异常时进行回滚
    @Transactional(rollbackFor = Exception.class)
    public String updateUserInfo(UpdateUserReqVO updateUserReqVO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(updateUserReqVO,sysUser);
        //密码进行校验——判空
        if(StringUtils.isEmpty(sysUser.getPassword())){
            sysUser.setPassword(null);
        }else {
            String salt = PasswordUtils.salt();
            String encode = PasswordUtils.md5(updateUserReqVO.getPassword() + salt);
            sysUser.setPassword(encode);
            sysUser.setSalt(salt);
        }
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            return "操作失败";
        }
//        i = 1/0;
        return "操作成功";
    }

    @Override
    public String deleted(String userId) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setUpdateTime(new Date());
        sysUser.setDeleted(1);
        int count  = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (count  == 0){
            return "删除失败";
        }else {
            return "删除成功";
        }
    }
}
