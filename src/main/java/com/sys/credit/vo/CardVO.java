package com.sys.credit.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Bandit
 * @createTime 2022/6/10 14:44
 */
@Data
public class CardVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
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
     * 信用卡归属者
     */
    private Long cardMember;
    /**
     * 信用卡类型名称
     */
    private String cardTypeName;
    /**
     * 信用卡发行商名字
     */
    private String cardPublisherName;
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
     * 信用卡图片的URL
     */
    private String cardImageUrl;
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
    private Integer delFlag;
    /**
     * 是否正在使用
     */
    private Integer usingFlag;


}
