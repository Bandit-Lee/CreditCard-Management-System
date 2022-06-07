package com.sys.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ${comments}
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-07 14:31:23
 */
@Data
@TableName("MEMBER")
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 会员id
	 */
	@TableId(type = IdType.AUTO)
	private Integer memberId;
	/**
	 * 会员名称
	 */
	private String memberName;
	/**
	 * 会员住址
	 */
	private String memberAddress;
	/**
	 * 删除标志
	 */
	@TableLogic
	private Integer delFlag;
	/**
	 * 会员电话号码
	 */
	private String memberTel;
	/**
	 * 会员密码
	 */
	private String memberPassword;
	/**
	 * 是否有配偶，1有，0无
	 */
	private Integer memberPartner;

}
