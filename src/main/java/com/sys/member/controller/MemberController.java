package com.sys.member.controller;


import com.common.entity.ResultVO;
import com.sys.credit.entity.CreditCardEntity;
import com.sys.member.entity.MemberEntity;
import com.sys.member.service.impl.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Bandit
 * @createTime 2022/6/7 15:14
 */
@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private static final String PREFIX = "/member";

    @Autowired
    MemberServiceImpl memberService;

    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResultVO save(@RequestBody MemberEntity memberEntity){
        log.info("输入的Member：{}", memberEntity);
        boolean save = memberService.saveRegister(memberEntity);
        return save ? ResultVO.success("注册成功") : ResultVO.error("该用户名已存在");
    }
}
