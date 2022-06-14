package com.sys.point.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.member.entity.MemberEntity;
import com.sys.member.entity.MemberPointEntity;
import com.sys.member.mapper.MemberPointMapper;
import com.sys.point.entity.PointEntity;
import com.sys.point.mapper.PointMapper;
import com.sys.point.service.PointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Bandit
 */
@Service
@Slf4j
public class PointServiceImpl extends ServiceImpl<PointMapper, PointEntity> implements PointService{

    @Autowired
    MemberPointMapper memberPointMapper;

    public List<PointEntity> queryList(Map<String, Object> params) {
        MemberEntity member = (MemberEntity) params.get("member");
        log.info("member:[{}]", member);
        QueryWrapper<PointEntity> wrapper = new QueryWrapper<PointEntity>();
        if (member.getMemberId() != null) {
            List<Long> pointIds = memberPointMapper.selectList(new LambdaQueryWrapper<MemberPointEntity>()
                    .eq(MemberPointEntity::getMemberId, member.getMemberId()))
                    .stream()
                    .map(MemberPointEntity::getPointId)
                    .collect(Collectors.toList());
            if (pointIds.size() != 0) {
                return listByIds(pointIds);
            } else {
                return null;
            }
        }
        return this.list(wrapper);

    }
}
