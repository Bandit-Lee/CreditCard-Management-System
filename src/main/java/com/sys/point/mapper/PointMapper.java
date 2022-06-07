package com.sys.point.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.point.entity.PointEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper extends BaseMapper<PointEntity> {
}
