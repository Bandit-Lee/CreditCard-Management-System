package com.sys.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.member.entity.MemberEntity;
import com.sys.member.mapper.MemberMapper;
import com.sys.member.service.MemberService;
import com.sys.point.entity.PointEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberService {

    public List<MemberEntity> queryList(Map<String, Object> params) {

        LambdaQueryWrapper<MemberEntity> wrapper = new QueryWrapper<MemberEntity>().lambda();
        return this.list(wrapper);
    }
}
