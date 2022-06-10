package com.sys.member.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.common.entity.ResultVO;
import com.sys.member.entity.MemberEntity;
import com.sys.member.service.impl.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private static final String PREFIX = "/member";

    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private MemberServiceImpl memberService;


    /**
     * 去查找页面
     * @param session
     * @param model
     */
    @GetMapping("/info")
    public String info(HttpSession session, Model model){
        MemberEntity member = (MemberEntity) session.getAttribute("user");
        member.setBirthdayString(df.format(member.getMemberBirthday()));
        model.addAttribute("member",member);
        return PREFIX + "/info";
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
        member.setBirthdayString(df.format(member.getMemberBirthday()));
        model.addAttribute("member",member);
        return PREFIX + "/edit";
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
    public ResultVO delete(@RequestBody Long[] memberIds){
        //TODO 级联删除所有的信用卡
        memberService.removeByIds(Arrays.asList(memberIds));
        return ResultVO.success();
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam Map<String, Object> params){
        List<MemberEntity> memberEntityList = memberService.queryList(params);
        return ResultVO.success().put("list", memberEntityList);
    }

}
