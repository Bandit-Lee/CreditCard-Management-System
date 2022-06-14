package com.sys.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@Data
@TableName("member_point")
@NoArgsConstructor
@AllArgsConstructor
public class MemberPointEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long mpId;
	/**
	 * 会员id
	 */
	private Long memberId;
	/**
	 * 积分id
	 */
	private Long pointId;
	/**
	 * 删除标志
	 */
	@TableLogic
	private Integer delFlag;

	public MemberPointEntity(Long memberId, Long pointId) {
		this.memberId = memberId;
		this.pointId = pointId;
	}
}
