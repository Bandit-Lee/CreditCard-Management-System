package com.sys.credit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

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
@TableName("card_card_publisher")
@NoArgsConstructor
@AllArgsConstructor
public class CardCardPublisherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long ccpId;
	/**
	 * 信用卡id
	 */
	private Long cardId;
	/**
	 * 发行商id
	 */
	private Long cardPublisherId;
	/**
	 * 删除标志
	 */
	@TableLogic
	private Integer delFlag;

	public CardCardPublisherEntity(Long cardId, Long cardPublisherId) {
		this.cardId = cardId;
		this.cardPublisherId = cardPublisherId;
	}
}
