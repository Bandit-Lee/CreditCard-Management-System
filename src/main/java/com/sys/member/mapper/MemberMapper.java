package com.sys.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<MemberEntity> {
}
