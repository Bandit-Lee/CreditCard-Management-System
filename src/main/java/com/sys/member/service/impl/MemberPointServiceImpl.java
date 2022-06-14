package com.sys.member.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberPointEntity;
import com.sys.member.mapper.MemberCardMapper;
import com.sys.member.mapper.MemberPointMapper;
import com.sys.member.service.MemberCardService;
import com.sys.member.service.MemberPointService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Bandit
 */
@Service("memberPointService")
public class MemberPointServiceImpl extends ServiceImpl<MemberPointMapper, MemberPointEntity> implements MemberPointService {

    @Override
    public List<MemberPointEntity> getListByMemberId(Long memberId) {
        return baseMapper.selectList(new QueryWrapper<MemberPointEntity>()
                .lambda()
                .eq(MemberPointEntity::getMemberId, memberId));
    }
}
