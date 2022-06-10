package com.sys.credit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.credit.entity.CardTypeEntity;


import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
public interface CardTypeService extends IService<CardTypeEntity> {

    /**
     * 查询类型列表
     * @param params
     * @return
     */
    List<CardTypeEntity> queryList(Map<String, Object> params);

    /**
     * 获取卡片的 TypeID 到 TypeName的映射
     * @return
     */
    Map<Long, String> getCardTypeToNameMap();

}

