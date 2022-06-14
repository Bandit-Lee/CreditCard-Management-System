package com.sys.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.member.entity.MemberEntity;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
public interface MemberService extends IService<MemberEntity> {

    /**
     * 用户登录校验
     * @param username 用户名
     * @param password 密码
     * @return 会员实体类
     */
    MemberEntity loginVerification(String username, String password);

    /**
     * 会员注册
     * @param memberEntity 会员实体类
     * @return true/false 成功或失败
     */
    boolean saveRegister(MemberEntity memberEntity);

    /**
     * 级联删除member相关的所有信息
     * @param member
     */
    void removeCascade(MemberEntity member);
}

