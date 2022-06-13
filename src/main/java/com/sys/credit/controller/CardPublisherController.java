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

import com.sys.credit.entity.CardPublisherEntity;
import com.sys.credit.service.CardPublisherService;


/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@RestController
@RequestMapping("credit/cardpublisher")
public class CardPublisherController {
    @Autowired
    private CardPublisherService cardPublisherService;

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
    @RequestMapping("/info/{publisherId}")
    public ResultVO info(@PathVariable("publisherId") Long publisherId){
		CardPublisherEntity cardPublisher = cardPublisherService.getById(publisherId);

        return ResultVO.success();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResultVO save(@RequestBody CardPublisherEntity cardPublisher){
		cardPublisherService.save(cardPublisher);

        return ResultVO.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody CardPublisherEntity cardPublisher){
		cardPublisherService.updateById(cardPublisher);

        return ResultVO.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody Long[] publisherIds){
		cardPublisherService.removeByIds(Arrays.asList(publisherIds));
        return ResultVO.success();
    }

}
