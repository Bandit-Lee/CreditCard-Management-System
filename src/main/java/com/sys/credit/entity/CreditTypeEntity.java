package com.sys.credit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Bandit
 * @createTime 2022/6/6 17:52
 */
@TableName("CARD_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreditTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TYPE_ID",type = IdType.AUTO)
    private Integer typeId;

    private String typeName;

    @TableLogic
    private Integer delFlag;
}
