package com.sys.credit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.credit.entity.CreditCardEntity;
import com.sys.credit.mapper.CreditCardMapper;
import com.sys.credit.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bandit
 * @createTime 2022/6/6 15:30
 */
@Service
public class CreditCardServiceImpl extends ServiceImpl<CreditCardMapper, CreditCardEntity> implements CreditCardService {

    public List<CreditCardEntity> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<CreditCardEntity> wrapper = new QueryWrapper<CreditCardEntity>().lambda();
        return this.list(wrapper);
    }

}
