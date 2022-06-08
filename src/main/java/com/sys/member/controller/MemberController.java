package com.sys.member.controller;

import com.common.entity.ResultVO;
import com.sys.member.entity.MemberEntity;
import com.sys.member.service.impl.MemberServiceImpl;
import com.sys.point.entity.PointEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {
    private static final String PREFIX= "/member";

    @Autowired
    MemberServiceImpl MemberService;
    /**
     * 新增
     */
    @GetMapping("/add")
    public String add(){
        return PREFIX + "/add";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@RequestBody MemberEntity memberEntity){
        MemberService.updateById(memberEntity);
        return ResultVO.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultVO delete(@RequestBody Long[] MemberIDs){
        MemberService.removeByIds(Arrays.asList(MemberIDs));
        return ResultVO.success();
    }

    /**
     * 查找
     */
    @RequestMapping("/info/{member}")
    public ResultVO info(@PathVariable("member") Long MemberID){
        MemberEntity memberEntity = MemberService.getById(MemberID);
        return ResultVO.success().put("memberEntity", memberEntity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam Map<String, Object> params){
        List<MemberEntity> MemberEntityList = MemberService.queryList(params);
        return ResultVO.success().put("list", MemberEntityList);
    }
}
