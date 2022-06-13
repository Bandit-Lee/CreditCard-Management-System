package com.sys.credit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.credit.mapper.CardMapper;
import com.sys.credit.vo.CardVO;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberEntity;
import com.sys.member.mapper.MemberCardMapper;
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
    public List<CardVO> queryListWithMember(MemberEntity memberEntity) {
        Long memberId = memberEntity.getMemberId();
        //Member-Card关联关系列表
        List<MemberCardEntity> memberCardList = memberCardService.getListByMemberId(memberId);

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
                    //TODO 设置信用卡的URL
                    BeanUtils.copyProperties(cardEntity, cardVO);
                    cardVO.setCardTypeName(typeIdToNameMap.get(cardEntity.getCardType()));
                    cardVO.setCardPublisherName(publisherIdToNameMap.get(cardEntity.getCardPublisher()));
                    // String transform = CardImageStoreUtils.transform(creditCardEntity);
                    // String url = CardImageStoreUtils.getURL(transform);
                    // log.info("transform:[{}],url:[{}]", transform, url);
                    // creditCardEntity.setCardImageURL(url);
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
        //UUID
        cardEntity.setCardNumber(UUID.randomUUID().toString());

        //加锁
        Long cardId;
        synchronized (SYNC) {
            save(cardEntity);
            cardId = baseMapper.getLastCardId();
        }

        MemberCardEntity memberCardEntity = new MemberCardEntity(memberId, cardId, usingFlag);
        log.info("memberCard:[{}]",memberCardEntity);
        memberCardService.save(memberCardEntity);
    }


    @Override
    public CardVO getCardById(Long cardId) {
        CardEntity creditCard = this.getById(cardId);
        CardVO cardVO = new CardVO();
        Map<Long, String> map = cardTypeService.getCardTypeToNameMap();
        //TODO 设置信用卡的URL
        cardVO.setCardTypeName(map.get(creditCard.getCardType()));
        return cardVO;
    }
}
