package com.sys.credit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.credit.entity.CardEntity;
import com.sys.credit.vo.CardVO;
import com.sys.member.entity.MemberEntity;

import java.util.List;
import java.util.Map;


/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:46:51
 */
public interface CardService extends IService<CardEntity> {

    /**
     * 获取CardList
     * @param params
     * @return
     */
    List<CardEntity> queryList(Map<String, Object> params);


    /**
     * 通过ID获取Card,并且封装数据
     * @param cardId
     * @return
     */
    CardVO getCardById(Long cardId);


    /**
     * 查询会员名下的card
     * @param memberEntity
     * @return
     */
    List<CardVO> queryListWithMember(MemberEntity memberEntity);

    /**
     * 级联更新
     * @param cardVO
     */
    void saveCascade(CardVO cardVO);

    /**
     * 申请信用卡升级
     * @param cardId
     */
    void upgradeCardLevel(Long cardId);

    /**
     * 审核信用卡
     * @param cardId
     * @param flag
     */
    void verifyCardById(Long cardId, Integer flag);

    /**
     * 查询所有未审核的信用卡
     * @return
     */
    List<CardVO> queryAllListUnVerified();
}

