package com.sys.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Bandit
 * @createTime 2022/6/7 14:20
 */
@Data
@TableName("MEMBER")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    @TableId(value = "MEMBER_ID", type = IdType.AUTO)
    private Integer memberID;


}
