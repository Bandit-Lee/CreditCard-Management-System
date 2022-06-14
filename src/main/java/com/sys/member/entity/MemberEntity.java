package com.sys.member.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@Data
@TableName("member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 会员ID
	 */
	@TableId(type = IdType.AUTO)
	private Long memberId;
	/**
	 * 会员名称
	 */
	private String memberName;
	/**
	 * 会员用户名
	 */
	private String memberUsername;
	/**
	 * 会员密码
	 */
	private String memberPassword;
	/**
	 * 会员住址
	 */
	private String memberAddress;
	/**
	 * 会员电子邮箱
	 */
	private String memberEmail;
	/**
	 * 会员电话
	 */
	private String memberTel;
	/**
	 * 会员生日
	 */
	private Date memberBirthday;
	/**
	 * 生日String
	 */
	@TableField(exist = false)
	private String birthdayString;
	/**
	 * 用户角色
	 */
	private String memberRole;
	/**
	 * 会员性别，1:男；0:女
	 */
	private Integer memberGender;
	/**
	 * 会员是否有配偶，1:有；0:无
	 */
	private Integer memberPartner;
	/**
	 * 逻辑删除标志
	 */
	@TableLogic
	private Integer delFlag;

}
