package com.sys.member.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@Mapper
public interface MemberCardMapper extends BaseMapper<MemberCardEntity> {
    /**
     * 通过cardId获取memberList
     * @param cardId
     * @return
     */
    MemberEntity getMemberByCardId(@Param("cardId") Long cardId);
}
