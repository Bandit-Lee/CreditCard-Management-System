package com.sys.credit.controller;

import java.util.Arrays;
import java.util.Map;

import com.common.entity.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sys.credit.entity.CardCardTypeEntity;
import com.sys.credit.service.CardCardTypeService;



/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@RestController
@RequestMapping("credit/cardcardtype")
public class CardCardTypeController {
    @Autowired
    private CardCardTypeService cardCardTypeService;

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
    @RequestMapping("/info/{cctId}")
    public ResultVO info(@PathVariable("cctId") Long cctId){
		CardCardTypeEntity cardCardType = cardCardTypeService.getById(cctId);

        return ResultVO.success();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResultVO save(@RequestBody CardCardTypeEntity cardCardType){
		cardCardTypeService.save(cardCardType);

        return ResultVO.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody CardCardTypeEntity cardCardType){
		cardCardTypeService.updateById(cardCardType);

        return ResultVO.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody Long[] cctIds){
		cardCardTypeService.removeByIds(Arrays.asList(cctIds));

        return ResultVO.success();
    }

}
