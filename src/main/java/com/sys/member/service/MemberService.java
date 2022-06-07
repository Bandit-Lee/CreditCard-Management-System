package com.sys.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.member.entity.MemberEntity;

/**
 * @author Bandit
 * @createTime 2022/6/7 15:12
 */
public interface MemberService extends IService<MemberEntity> {

    MemberEntity LoginVerification(String username, String password);

}
