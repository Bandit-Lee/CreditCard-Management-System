package com.sys.member.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberEntity;
import com.sys.member.entity.MemberPaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@Mapper
public interface MemberPaymentMapper extends BaseMapper<MemberPaymentEntity> {

}
