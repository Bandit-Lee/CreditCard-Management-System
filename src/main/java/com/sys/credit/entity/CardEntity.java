package com.sys.credit.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:46:51
 */
@Data
@TableName("card")
public class CardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(type = IdType.AUTO)
	private Long cardId;
	/**
	 * 信用卡UUID卡号
	 */
	private String cardNumber;
	/**
	 * 信用卡类型:个人卡，家庭卡，企业卡，ETC卡等
	 */
	private Long cardType;
	/**
	 * 信用卡发行商
	 */
	private Long cardPublisher;
	/**
	 * 家庭卡卡号
	 */
	private String familyNumber;
	/**
	 * 家庭成员名字
	 */
	private String familyMemberName;
	/**
	 * 家庭成员工作行业
	 */
	private String familyWorkProfession;
	/**
	 * 家庭成员工作地点
	 */
	private String familyWorkLocation;
	/**
	 * 工作行业
	 */
	private String workProfession;
	/**
	 * 工作地点
	 */
	private String workLocation;
	/**
	 * 是否为金卡
	 */
	private Integer goldFlag;
	/**
	 * 审核标志：1:通过，0:不通过
	 */
	private Integer verifyFlag;
	/**
	 * 删除标志
	 */
	@TableLogic
	private Integer delFlag;

}
