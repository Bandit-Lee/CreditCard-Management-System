package com.sys.credit.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Bandit
 * @createTime 2022/6/6 15:08
 */
@TableName("CREDIT_CARD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CARD_ID", type = IdType.AUTO)
    private Integer cardId;

    private Integer cardType;

    @TableField(exist = false)
    private String cardTypeName;

    private String cardDescribe;

    private Integer cardOwner;

    @TableLogic
    private Integer delFlag;
}
