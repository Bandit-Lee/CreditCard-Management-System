package com.sys.member.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.member.entity.MemberCardEntity;

import java.util.List;


/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
public interface MemberCardService extends IService<MemberCardEntity> {

    /**
     * 传入会员ID查询 member和Card的关联关系表
     * @param memberId
     * @return
     */
    List<MemberCardEntity> getListByMemberId(Long memberId);
}

