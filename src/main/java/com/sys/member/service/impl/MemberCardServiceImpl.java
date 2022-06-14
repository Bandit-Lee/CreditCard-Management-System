package com.sys.member.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberEntity;
import com.sys.member.mapper.MemberCardMapper;
import com.sys.member.service.MemberCardService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Bandit
 */
@Service("memberCardService")
public class MemberCardServiceImpl extends ServiceImpl<MemberCardMapper, MemberCardEntity> implements MemberCardService {

    @Override
    public List<MemberCardEntity> getListByMemberId(Long memberId) {
        return baseMapper.selectList(new QueryWrapper<MemberCardEntity>()
                .lambda()
                .eq(MemberCardEntity::getMemberId, memberId));
    }

    @Override
    public MemberEntity getMemberByCardId(Long cardId) {
        return baseMapper.getMemberByCardId(cardId);
    }
}
