package com.sys.credit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@Data
@TableName("card_publisher")
public class CardPublisherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 发行商ID
	 */
	@TableId(type = IdType.AUTO)
	private Long publisherId;
	/**
	 * 发行商名字
	 */
	private String publisherName;
	/**
	 * 删除标志
	 */
	@TableLogic
	private Integer delFlag;

}
