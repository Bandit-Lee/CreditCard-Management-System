package com.sys.credit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.credit.entity.CreditCardEntity;

/**
 * @author Bandit
 * @createTime 2022/6/6 15:28
 */
public interface CreditCardService extends IService<CreditCardEntity> {

    CreditCardEntity getCardById(Integer cardId);
}
