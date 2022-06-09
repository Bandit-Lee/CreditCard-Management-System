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

    /**
     * 信用卡类型：属于哪个运营商
     */
    private Integer cardType;

    @TableField(exist = false)
    private String cardTypeName;

    /**
     * 信用卡等级描述：普通 -> 铜卡 -> 银卡 -> 金卡
     */
    private String cardDescribe;

    private Integer cardOwner;

    @TableField(exist = false)
    private String cardImageURL;

    @TableLogic
    private Integer delFlag;
}
