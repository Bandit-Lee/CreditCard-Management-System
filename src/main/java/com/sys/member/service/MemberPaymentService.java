package com.sys.member.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberEntity;
import com.sys.member.entity.MemberPaymentEntity;
import com.sys.member.mapper.MemberPaymentMapper;

import java.util.List;


/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
public interface MemberPaymentService extends IService<MemberPaymentEntity> {

    /**
     * 通过memberId查询关联关系
     * @param memberId
     * @return
     */
    List<MemberPaymentEntity> getListByMemberId(Long memberId);
}

