package com.sys.credit.entity;

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
@TableName("card_card_type")
@NoArgsConstructor
@AllArgsConstructor
public class CardCardTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long cctId;
	/**
	 * 信用卡id
	 */
	private Long cardId;
	/**
	 * 信用卡类型id
	 */
	private Long cardTypeId;
	/**
	 * 删除标志
	 */
	@TableLogic
	private Integer delFlag;

	public CardCardTypeEntity(Long cardId, Long cardTypeId) {
		this.cardId = cardId;
		this.cardTypeId = cardTypeId;
	}
}
