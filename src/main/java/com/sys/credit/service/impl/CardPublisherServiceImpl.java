package com.sys.credit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.credit.mapper.CardPublisherMapper;
import org.springframework.stereotype.Service;
import com.sys.credit.entity.CardPublisherEntity;
import com.sys.credit.service.CardPublisherService;

import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author Bandit
 */
@Service("cardPublisherService")
public class CardPublisherServiceImpl extends ServiceImpl<CardPublisherMapper, CardPublisherEntity> implements CardPublisherService {


    @Override
    public Map<Long, String> getPublisherIdToNameMap() {
        return list()
                .stream()
                .collect(Collectors.toMap(CardPublisherEntity::getPublisherId, CardPublisherEntity::getPublisherName));
    }
}
