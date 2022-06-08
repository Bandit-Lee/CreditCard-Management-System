package com.sys.point.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName("POINT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PointEntity {
    /**
     * 积分id
     */
    @TableId(value = "POINT_ID", type = IdType.AUTO)
    private Integer pointID;
    /**
     * 积分数值
     */
    private Integer pointNUM;
    /**
     * 积分状态
     */
    @TableLogic
    private Integer pointStatus;

}
