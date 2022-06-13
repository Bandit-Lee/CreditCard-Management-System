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
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@Data
@TableName("member_card")
@NoArgsConstructor
@AllArgsConstructor
public class MemberCardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long mcId;
	/**
	 * 会员id
	 */
	private Long memberId;
	/**
	 * 信用卡id
	 */
	private Long cardId;
	/**
	 * 正在使用
	 */
	private Integer usingFlag;
	/**
	 * 删除标志
	 */
	@TableLogic
	private Integer delFlag;

	public MemberCardEntity(Long memberId, Long cardId, Integer usingFlag) {
		this.memberId = memberId;
		this.cardId = cardId;
		this.usingFlag = usingFlag;
	}
}
