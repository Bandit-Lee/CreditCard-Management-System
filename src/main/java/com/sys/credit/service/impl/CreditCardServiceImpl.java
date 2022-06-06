package com.sys.credit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.credit.entity.CreditCard;
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
public class CreditCardServiceImpl extends ServiceImpl<CreditCardMapper, CreditCard> implements CreditCardService {

    public List<CreditCard> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<CreditCard> wrapper = new QueryWrapper<CreditCard>().lambda();
        return this.list(wrapper);
    }

}
