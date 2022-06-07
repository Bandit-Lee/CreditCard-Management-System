package com.sys.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Bandit
 * @createTime 2022/6/7 15:11
 */
@Mapper
public interface MemberMapper extends BaseMapper<MemberEntity> {
}
