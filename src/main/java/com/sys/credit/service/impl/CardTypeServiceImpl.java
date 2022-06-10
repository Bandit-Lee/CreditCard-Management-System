package com.sys.credit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.credit.entity.CardTypeEntity;
import com.sys.credit.mapper.CardTypeMapper;
import com.sys.credit.service.CardTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author Bandit
 */
@Service("cardTypeService")
public class CardTypeServiceImpl extends ServiceImpl<CardTypeMapper, CardTypeEntity> implements CardTypeService {

    public List<CardTypeEntity> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<CardTypeEntity> wrapper = new QueryWrapper<CardTypeEntity>().lambda();
        return this.list(wrapper);
    }


    /**
     * 获取卡片的 TypeID 到 TypeName的映射
     * @return
     */
    @Override
    public Map<Long, String> getCardTypeToNameMap() {
        return this.baseMapper
                .selectList(null)
                .stream()
                .collect(Collectors.toMap(CardTypeEntity::getTypeId, CardTypeEntity::getTypeName));
    }



}
