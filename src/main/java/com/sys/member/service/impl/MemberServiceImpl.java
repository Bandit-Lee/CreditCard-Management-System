package com.sys.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.credit.entity.CreditCardEntity;
import com.sys.member.entity.MemberEntity;
import com.sys.member.mapper.MemberMapper;
import com.sys.member.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bandit
 * @createTime 2022/6/7 15:12
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberService {

    public List<MemberEntity> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<MemberEntity> wrapper = new QueryWrapper<MemberEntity>().lambda();
        return this.list(wrapper);
    }

    public MemberEntity LoginVerification(String username, String password) {
        MemberMapper memberMapper = this.getBaseMapper();
        MemberEntity memberEntity = memberMapper.selectOne(new LambdaQueryWrapper<MemberEntity>()
                .eq(MemberEntity::getMemberUsername, username));
        return memberEntity != null && password.equals(memberEntity.getMemberPassword()) ?
                memberEntity : null;
    }

    /**
     * 不为空才save，否则报错
     * @param memberEntity
     * @return
     */
    @Override
    public boolean saveRegister(MemberEntity memberEntity) {
        MemberMapper memberMapper = this.getBaseMapper();
        MemberEntity member = memberMapper.selectOne(new LambdaQueryWrapper<MemberEntity>()
                .eq(MemberEntity::getMemberUsername, memberEntity.getMemberUsername()));
        if (member!=null) {
            return false;
        } else {
            this.save(memberEntity);
            return true;
        }
    }
}
