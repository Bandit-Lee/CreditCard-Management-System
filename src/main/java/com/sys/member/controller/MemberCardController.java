package com.sys.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.common.entity.ResultVO;
import com.sys.member.entity.MemberCardEntity;
import com.sys.member.service.impl.MemberCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@RestController
@RequestMapping("credit/membercard")
public class MemberCardController {
    @Autowired
    private MemberCardServiceImpl memberCardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResultVO list(@RequestParam Map<String, Object> params){
        return ResultVO.success();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mcId}")
    public ResultVO info(@PathVariable("mcId") Long mcId){
		MemberCardEntity memberCard = memberCardService.getById(mcId);

        return ResultVO.success();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResultVO save(@RequestBody MemberCardEntity memberCard){
		memberCardService.save(memberCard);

        return ResultVO.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody MemberCardEntity memberCard){
		memberCardService.updateById(memberCard);

        return ResultVO.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody Long[] mcIds){
		memberCardService.removeByIds(Arrays.asList(mcIds));

        return ResultVO.success();
    }

}
