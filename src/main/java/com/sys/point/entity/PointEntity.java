package com.sys.point.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Bandit
 */
@TableName("point")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PointEntity {
    /**
     * 积分id
     */
    @TableId(type = IdType.AUTO)
    private Long pointId;
    /**
     * 积分数值
     */
    private Long pointNum;
    /**
     * 积分记录日期
     */
    private Date pointDate;
    /**
     * 删除标志
     */
    @TableLogic
    private Integer delFlag;

}
