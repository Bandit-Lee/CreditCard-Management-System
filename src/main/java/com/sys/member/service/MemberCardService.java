package com.sys.member.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
public interface MemberCardService extends IService<MemberCardEntity> {

    /**
     * 传入会员ID查询 member和Card的关联关系表
     * @param memberId
     * @return
     */
    List<MemberCardEntity> getListByMemberId(Long memberId);

    /**
     * 通过cardId获取member
     * @param cardId
     * @return
     */
    MemberEntity getMemberByCardId(Long cardId);
}

