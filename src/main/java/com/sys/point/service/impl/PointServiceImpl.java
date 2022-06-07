package com.sys.point.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.point.entity.PointEntity;
import com.sys.point.mapper.PointMapper;
import com.sys.point.service.PointService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PointServiceImpl extends ServiceImpl<PointMapper, PointEntity> implements PointService{
    public List<PointEntity> queryList(Map<String, Object> params) {

        LambdaQueryWrapper<PointEntity> wrapper = new QueryWrapper<PointEntity>().lambda();
        return this.list(wrapper);

    }
}
