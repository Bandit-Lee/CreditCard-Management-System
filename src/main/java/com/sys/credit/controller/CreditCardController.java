package com.sys.credit.controller;

import com.common.entity.ResultVO;
import com.sys.credit.entity.CreditCard;
import com.sys.credit.service.impl.CreditCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Bandit
 * @createTime 2022/6/6 17:02
 */
@Controller("/card")
public class CreditCardController {

    @Autowired
    CreditCardServiceImpl creditCardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResultVO list(@RequestParam Map<String, Object> params){
        List<CreditCard> creditCardList = creditCardService.queryList(params);
        return ResultVO.success().put("list", creditCardList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{creditCard}")
    public ResultVO info(@PathVariable("creditCard") Long cardId){
        CreditCard creditCard = creditCardService.getById(cardId);
        return ResultVO.success().put("creditCard", creditCard);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResultVO save(@RequestBody CreditCard creditCard){
        creditCardService.save(creditCard);
        return ResultVO.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public ResultVO update(@RequestBody CreditCard creditCard){
        creditCardService.updateById(creditCard);
        return ResultVO.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody Long[] creditCardIds){
        creditCardService.removeByIds(Arrays.asList(creditCardIds));
        return ResultVO.success();
    }

}
