package com.sys.credit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.credit.entity.CreditTypeEntity;
import com.sys.credit.mapper.CreditTypeMapper;
import com.sys.credit.service.CreditTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bandit
 * @createTime 2022/6/6 17:59
 */
@Service
public class CreditTypeServiceImpl extends ServiceImpl<CreditTypeMapper, CreditTypeEntity> implements CreditTypeService {

    public List<CreditTypeEntity> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<CreditTypeEntity> wrapper = new QueryWrapper<CreditTypeEntity>().lambda();
        return this.list(wrapper);
    }
}
