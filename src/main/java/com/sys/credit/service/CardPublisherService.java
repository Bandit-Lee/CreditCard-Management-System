package com.sys.credit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.credit.entity.CardPublisherEntity;

import java.util.Map;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
public interface CardPublisherService extends IService<CardPublisherEntity> {

    /**
     * 获取publisher的ID -> Name的映射
     * @return
     */
    Map<Long, String> getPublisherIdToNameMap();
}

