package com.sys.credit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bandit
 * @createTime 2022/6/6 15:08
 */
@TableName("CREDIT_CARD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardEntity {

    @TableId(value = "CARD_ID", type = IdType.AUTO)
    private Integer cardId;

    private Integer cardType;

    private String cardDescribe;

    private Integer cardOwner;

    @TableLogic
    private Integer delFlag;
}
