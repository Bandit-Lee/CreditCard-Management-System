package com.sys.credit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.CardImageStoreUtils;
import com.sys.credit.mapper.CardMapper;
import com.sys.credit.vo.CardVO;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberEntity;
import com.sys.member.service.impl.MemberCardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sys.credit.entity.CardEntity;
import com.sys.credit.service.CardService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Bandit
 */
@Service("cardService")
@Slf4j
public class CardServiceImpl extends ServiceImpl<CardMapper, CardEntity> implements CardService {

    @Autowired
    CardTypeServiceImpl cardTypeService;

    @Autowired
    MemberCardServiceImpl memberCardService;


    @Autowired
    CardPublisherServiceImpl cardPublisherService;

    private static final Object SYNC = new Object();

    @Override
    public List<CardEntity> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<CardEntity> wrapper = new QueryWrapper<CardEntity>().lambda();
        return this.list(wrapper);
    }

    @Override
    public List<CardVO> queryAllListUnVerified() {
        Map<Long, String> typeIdToNameMap = cardTypeService.getCardTypeToNameMap();
        Map<Long, String> publisherIdToNameMap = cardPublisherService.getPublisherIdToNameMap();
        return list(new QueryWrapper<CardEntity>()
                .lambda()
                .eq(CardEntity::getVerifyFlag, 0)
                .eq(CardEntity::getDelFlag, 0))
                .stream().map(cardEntity -> {
                    CardVO cardVO = new CardVO();
                    BeanUtils.copyProperties(cardEntity, cardVO);
                    cardVO.setCardTypeName(typeIdToNameMap.get(cardEntity.getCardType()));
                    cardVO.setCardPublisherName(publisherIdToNameMap.get(cardEntity.getCardPublisher()));
                    MemberEntity member = memberCardService.getMemberByCardId(cardEntity.getCardId());
                    cardVO.setCardMemberName(member.getMemberName());
                    cardVO.setCardMember(member.getMemberId());
                    String transform = CardImageStoreUtils.transform(cardEntity);
                    String url = CardImageStoreUtils.getUrl(transform);
                    log.info("transform:[{}],url:[{}]", transform, url);
                    cardVO.setCardImageUrl(url);
                    return cardVO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<CardVO> queryListWithMember(MemberEntity memberEntity) {
        Long memberId = memberEntity.getMemberId();
        //Member-Card关联关系列表
        List<MemberCardEntity> memberCardList = memberCardService.getListByMemberId(memberId);
        if (memberCardList == null || memberCardList.size() == 0)
            return null;
        //CardIds
        List<Long> cardIds = memberCardList
                .stream()
                .map(MemberCardEntity::getCardId)
                .collect(Collectors.toList());
        //获取 typeId -> typeName 的映射
        Map<Long, String> typeIdToNameMap = cardTypeService.getCardTypeToNameMap();
        Map<Long, String> publisherIdToNameMap = cardPublisherService.getPublisherIdToNameMap();
        return baseMapper.selectBatchIds(cardIds)
                .stream()
                .map(cardEntity -> {
                    CardVO cardVO = new CardVO();
                    BeanUtils.copyProperties(cardEntity, cardVO);
                    cardVO.setCardTypeName(typeIdToNameMap.get(cardEntity.getCardType()));
                    cardVO.setCardPublisherName(publisherIdToNameMap.get(cardEntity.getCardPublisher()));
                    String transform = CardImageStoreUtils.transform(cardEntity);
                    String url = CardImageStoreUtils.getUrl(transform);
                    log.info("transform:[{}],url:[{}]", transform, url);
                    cardVO.setCardImageUrl(url);
                    return cardVO;
                }).collect(Collectors.toList());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveCascade(CardVO cardVO) {
        log.info("cardVO:[{}]",cardVO);
        Long memberId = cardVO.getCardMember();
        Integer usingFlag = cardVO.getUsingFlag();
        //VO拷贝回实体类
        CardEntity cardEntity = new CardEntity();
        BeanUtils.copyProperties(cardVO, cardEntity);
        //卡号UUID
        cardEntity.setCardNumber(UUID.randomUUID().toString());
        cardEntity.setVerifyFlag(0);
        if (cardEntity.getCardType() == 2) {
            //如果是家庭卡，分配一个家庭卡号
            cardEntity.setFamilyNumber(UUID.randomUUID().toString());
        }
        //加锁获取ID
        Long cardId;
        synchronized (SYNC) {
            save(cardEntity);
            cardId = baseMapper.getLastCardId();
        }
        memberCardService.save(new MemberCardEntity(memberId, cardId, usingFlag));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void upgradeCardLevel(Long cardId) {
        CardEntity cardEntity = getById(cardId);
        cardEntity.setGoldFlag(1);
        cardEntity.setVerifyFlag(0);
        updateById(cardEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void verifyCardById(Long cardId, Integer flag){
        CardEntity cardEntity = getById(cardId);
        if (flag == 0) {
            // 不通过
            cardEntity.setGoldFlag(0);
        }
        cardEntity.setVerifyFlag(1);
        updateById(cardEntity);
    }


    @Override
    public CardVO getCardById(Long cardId) {
        CardEntity cardEntity = this.getById(cardId);
        CardVO cardVO = new CardVO();
        BeanUtils.copyProperties(cardEntity, cardVO);
        Map<Long, String> typeIdToNameMap = cardTypeService.getCardTypeToNameMap();
        Map<Long, String> publisherIdToNameMap = cardPublisherService.getPublisherIdToNameMap();
        cardVO.setCardTypeName(typeIdToNameMap.get(cardEntity.getCardType()));
        cardVO.setCardPublisherName(publisherIdToNameMap.get(cardEntity.getCardPublisher()));
        String transform = CardImageStoreUtils.transform(cardEntity);
        String url = CardImageStoreUtils.getUrl(transform);
        cardVO.setCardImageUrl(url);
        return cardVO;
    }
}
