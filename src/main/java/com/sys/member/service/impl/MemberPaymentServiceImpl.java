package com.sys.member.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.member.entity.MemberPaymentEntity;
import com.sys.member.mapper.MemberPaymentMapper;
import com.sys.member.service.MemberPaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bandit
 */
@Service("memberPaymentService")
public class MemberPaymentServiceImpl extends ServiceImpl<MemberPaymentMapper, MemberPaymentEntity> implements MemberPaymentService {

    @Override
    public List<MemberPaymentEntity> getListByMemberId(Long memberId) {
        return baseMapper.selectList(new LambdaQueryWrapper<MemberPaymentEntity>()
                .eq(MemberPaymentEntity::getMemberId, memberId));
    }
}
