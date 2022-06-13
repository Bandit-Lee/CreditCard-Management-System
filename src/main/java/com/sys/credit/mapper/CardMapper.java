package com.sys.credit.mapper;

import com.sys.credit.entity.CardEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:46:51
 */
@Mapper
public interface CardMapper extends BaseMapper<CardEntity> {

    /**
     * 获取最后插入的一个id
     * @return
     */
    Long getLastCardId();
}
