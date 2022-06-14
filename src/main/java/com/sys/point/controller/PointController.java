package com.sys.point.controller;

import com.common.entity.ResultVO;
import com.sys.member.entity.MemberEntity;
import com.sys.point.entity.PointEntity;
import com.sys.point.service.impl.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/point")
public class PointController {

    private static final String PREFIX= "/point";

    @Autowired
    PointServiceImpl pointService;
    /**
     * 新增
     */
    @GetMapping("/add")
    public String add() {
        return PREFIX + "/add";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@RequestBody PointEntity pointEntity){
        pointService.updateById(pointEntity);
        return ResultVO.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultVO delete(@RequestBody Long[] pointIds){
        pointService.removeByIds(Arrays.asList(pointIds));
        return ResultVO.success();
    }

    /**
     * 查找
     */
    @RequestMapping("/info/{point}")
    public ResultVO info(@PathVariable("point") Long pointId){
        PointEntity pointEntity = pointService.getById(pointId);
        return ResultVO.success().put("PointEntity", pointEntity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public String list(HttpSession session, Model model){
        MemberEntity user = (MemberEntity) session.getAttribute("user");
        Map<String, Object> params = new HashMap<>();
        params.put("member", user);
        List<PointEntity> pointEntityList = pointService.queryList(params);
        model.addAttribute("pointlist",pointEntityList);
        return PREFIX + "/list";
    }


}
