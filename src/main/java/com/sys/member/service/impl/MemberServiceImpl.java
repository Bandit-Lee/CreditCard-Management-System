package com.sys.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.RoleEnum;
import com.sys.credit.service.impl.CardServiceImpl;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.entity.MemberEntity;
import com.sys.member.entity.MemberPaymentEntity;
import com.sys.member.entity.MemberPointEntity;
import com.sys.member.mapper.MemberMapper;
import com.sys.member.service.MemberPaymentService;
import com.sys.member.service.MemberService;
import com.sys.point.service.impl.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Bandit
 */
@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberService {

    @Autowired
    MemberCardServiceImpl memberCardService;

    @Autowired
    MemberPaymentServiceImpl memberPaymentService;

    @Autowired
    MemberPointServiceImpl memberPointService;

    @Autowired
    CardServiceImpl cardService;

    @Autowired
    PointServiceImpl pointService;

    public List<MemberEntity> queryList(Map<String, Object> params) {
        LambdaQueryWrapper<MemberEntity> wrapper = new QueryWrapper<MemberEntity>().lambda();
        return this.list(wrapper);
    }

    public MemberEntity loginVerification(String username, String password) {
        MemberEntity memberEntity = baseMapper.selectOne(new LambdaQueryWrapper<MemberEntity>()
                .eq(MemberEntity::getMemberUsername, username));
        return memberEntity != null && password.equals(memberEntity.getMemberPassword()) ?
                memberEntity : null;
    }

    /**
     * 不为空才save，否则报错
     * @param memberEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRegister(MemberEntity memberEntity) {
        MemberEntity member = baseMapper.selectOne(new LambdaQueryWrapper<MemberEntity>()
                .eq(MemberEntity::getMemberUsername, memberEntity.getMemberUsername()));
        if (member != null) {
            return false;
        } else {
            memberEntity.setMemberRole("user");
            this.save(memberEntity);
            return true;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeCascade(MemberEntity member) {
        Long memberId = member.getMemberId();
        String role = member.getMemberRole();
        if (memberId != null && !RoleEnum.ADMIN.getRole().equals(role)) {
            baseMapper.deleteById(memberId);
            //先删有关联的表的数据
            List<Long> cardIds = memberCardService
                    .getListByMemberId(memberId)
                    .stream()
                    .map(MemberCardEntity::getCardId)
                    .collect(Collectors.toList());
            List<Long> pointIds = memberPointService
                    .getListByMemberId(memberId)
                    .stream()
                    .map(MemberPointEntity::getPointId)
                    .collect(Collectors.toList());
            List<Long> paymentIds = memberPaymentService
                    .getListByMemberId(memberId)
                    .stream()
                    .map(MemberPaymentEntity::getPaymentId)
                    .collect(Collectors.toList());
            if (cardIds.size() != 0) {
                cardService.removeByIds(cardIds);
            }
            if (pointIds.size() != 0) {
                pointService.removeByIds(pointIds);
            }
            if (paymentIds.size() != 0) {
                //TODO paymentService还未写
            }
            //再删关联关系表
            memberCardService.remove(new LambdaQueryWrapper<MemberCardEntity>().eq(MemberCardEntity::getMemberId, memberId));
            memberPaymentService.remove(new LambdaQueryWrapper<MemberPaymentEntity>().eq(MemberPaymentEntity::getMemberId, memberId));
            memberPointService.remove(new LambdaQueryWrapper<MemberPointEntity>().eq(MemberPointEntity::getMemberId, memberId));
        }
    }
}
