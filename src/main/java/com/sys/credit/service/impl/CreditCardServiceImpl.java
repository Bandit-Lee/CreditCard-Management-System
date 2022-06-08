package com.sys.credit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.credit.entity.CreditCardEntity;
import com.sys.credit.entity.CreditTypeEntity;
import com.sys.credit.mapper.CreditCardMapper;
import com.sys.credit.mapper.CreditTypeMapper;
import com.sys.credit.service.CreditCardService;
import com.sys.member.entity.MemberEntity;
import com.sys.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author Bandit
 * @createTime 2022/6/6 15:30
 */
@Service
public class CreditCardServiceImpl extends ServiceImpl<CreditCardMapper, CreditCardEntity> implements CreditCardService {

    @Autowired
    CreditTypeMapper creditTypeMapper;

    public List<CreditCardEntity> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<CreditCardEntity> wrapper = new QueryWrapper<CreditCardEntity>().lambda();
        return this.list(wrapper);
    }

    public List<CreditCardEntity> queryListWithMember(MemberEntity memberEntity) {
        Integer memberId = memberEntity.getMemberId();
        //获取 typeId -> typeName 的映射
        Map<Integer, String> map = creditTypeMapper
                .selectList(null)
                .stream()
                .collect(Collectors.toMap(CreditTypeEntity::getTypeId, CreditTypeEntity::getTypeName));

        //获取cardEntity里只有id，所以要获取cardType的名字封装到entity里
        return this.list(new QueryWrapper<CreditCardEntity>()
                        .lambda()
                        .eq(CreditCardEntity::getCardOwner, memberId))
                .stream()
                .peek(creditCardEntity -> {
                    String typeName = map.get(creditCardEntity.getCardType());
                    creditCardEntity.setCardTypeName(typeName);
                }).collect(Collectors.toList());
    }

}
