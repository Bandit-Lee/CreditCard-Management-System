package com.sys.member.controller;


import com.common.entity.ResultVO;

import com.sys.member.entity.MemberEntity;
import com.sys.member.service.impl.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    /**
     * 去修改页面
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/edit")
    public String edit(HttpSession session, Model model) {
        MemberEntity member = (MemberEntity) session.getAttribute("user");
        model.addAttribute("member",member);
        return PREFIX + "/edit";
    }


    /**
     * 去查找页面
     * @param session
     * @param model
     */
    @GetMapping("/info")
    public String info(HttpSession session, Model model){
        MemberEntity member = (MemberEntity) session.getAttribute("user");
        model.addAttribute("member",member);
        return PREFIX + "/info";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@RequestBody MemberEntity memberEntity){
        memberService.updateById(memberEntity);
        return ResultVO.success();
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResultVO save(@RequestBody MemberEntity memberEntity){
        log.info("输入的Member：{}", memberEntity);
        boolean save = memberService.saveRegister(memberEntity);
        return save ? ResultVO.success("注册成功") : ResultVO.error("该用户名已存在");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultVO delete(@RequestBody Long[] MemberIDs){
        memberService.removeByIds(Arrays.asList(MemberIDs));
        return ResultVO.success();
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam Map<String, Object> params){
        List<MemberEntity> MemberEntityList = memberService.queryList(params);
        return ResultVO.success().put("list", MemberEntityList);
    }
}
