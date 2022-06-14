package com.sys.payment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Bandit
 * @createTime 2022/6/13 11:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("payment")
public class PaymentEntity {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long paymentId;
    /**
     * 支付金额
     */
    private BigDecimal paymentValue;
    /**
     * 支付日期
     */
    private Date paymentDate;
    /**
     * 删除标志
     */
    private Integer delFlag;
}
