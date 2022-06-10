package com.sys.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.member.entity.MemberEntity;
import com.sys.member.mapper.MemberMapper;
import com.sys.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Bandit
 */
@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    public List<MemberEntity> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<MemberEntity> wrapper = new QueryWrapper<MemberEntity>().lambda();
        return this.list(wrapper);
    }

    public MemberEntity loginVerification(String username, String password) {
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
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRegister(MemberEntity memberEntity) {
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
