package com.sys.point.controller;

import com.common.entity.ResultVO;
import com.sys.point.entity.PointEntity;
import com.sys.point.service.impl.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public ResultVO delete(@RequestBody Long[] pointIDs){
        pointService.removeByIds(Arrays.asList(pointIDs));
        return ResultVO.success();
    }

    /**
     * 查找
     */
    @RequestMapping("/info/{point}")
    public ResultVO info(@PathVariable("point") Long pointID){
        PointEntity pointEntity = pointService.getById(pointID);
        return ResultVO.success().put("PointEntity", pointEntity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam Map<String, Object> params){
        List<PointEntity> PointEntityList = pointService.queryList(params);
        return ResultVO.success().put("list", PointEntityList);
    }


}
