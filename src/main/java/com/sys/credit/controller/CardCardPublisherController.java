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

import com.sys.credit.entity.CardCardPublisherEntity;
import com.sys.credit.service.CardCardPublisherService;



/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@RestController
@RequestMapping("credit/cardcardpublisher")
public class CardCardPublisherController {
    @Autowired
    private CardCardPublisherService cardCardPublisherService;

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
    @RequestMapping("/info/{ccpId}")
    public ResultVO info(@PathVariable("ccpId") Long ccpId){
		CardCardPublisherEntity cardCardPublisher = cardCardPublisherService.getById(ccpId);

        return ResultVO.success();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResultVO save(@RequestBody CardCardPublisherEntity cardCardPublisher){
		cardCardPublisherService.save(cardCardPublisher);

        return ResultVO.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody CardCardPublisherEntity cardCardPublisher){
		cardCardPublisherService.updateById(cardCardPublisher);

        return ResultVO.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody Long[] ccpIds){
		cardCardPublisherService.removeByIds(Arrays.asList(ccpIds));

        return ResultVO.success();
    }

}
