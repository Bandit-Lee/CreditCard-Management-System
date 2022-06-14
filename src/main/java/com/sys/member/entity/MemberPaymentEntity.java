package com.sys.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bandit
 * @createTime 2022/6/13 11:30
 */
@TableName("member_payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberPaymentEntity {

    /**
     * 主键id
     */
    @TableId
    private Long mpId;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 订单id
     */
    private Long paymentId;
    /**
     * 删除标志
     */
    private Integer delFlag;
}
