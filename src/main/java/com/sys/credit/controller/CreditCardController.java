package com.sys.credit.controller;

import com.common.entity.ResultVO;
import com.sys.credit.entity.CreditCard;
import com.sys.credit.service.impl.CreditCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Bandit
 * @createTime 2022/6/6 17:02
 */
@Controller
@RequestMapping("/credit")
public class CreditCardController {

    private static final String PREFIX= "/credit";

    @Autowired
    CreditCardServiceImpl creditCardService;

    @GetMapping("/card")
    public String creditCard(ModelMap modelMap) {
        List<CreditCard> list = creditCardService.queryList(null);
        modelMap.put("creditCardList", list);
        return PREFIX + "/card";
    }

    @GetMapping("/add")
    public String add() {
        return PREFIX + "/add";
    }

    @GetMapping("/edit/{cardId}")
    public String edit(@PathVariable Integer cardId, ModelMap modelMap) {
        CreditCard creditCard = creditCardService.getById(cardId);
        modelMap.put("creditCard", creditCard);
        return PREFIX + "/edit";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
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
    @ResponseBody
    public ResultVO save(@RequestBody CreditCard creditCard){
        creditCardService.save(creditCard);
        return ResultVO.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@RequestBody CreditCard creditCard){
        creditCardService.updateById(creditCard);
        return ResultVO.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultVO delete(@RequestBody Long[] creditCardIds){
        creditCardService.removeByIds(Arrays.asList(creditCardIds));
        return ResultVO.success();
    }

}
