package com.sys.credit.controller;

import com.common.entity.ResultVO;
import com.sys.credit.entity.CreditCardEntity;
import com.sys.credit.service.impl.CreditCardServiceImpl;
import com.sys.member.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        List<CreditCardEntity> list = creditCardService.queryList(null);
        modelMap.put("creditCardList", list);
        return PREFIX + "/card";
    }

    @GetMapping("/add")
    public String add() {
        return PREFIX + "/add";
    }

    @GetMapping("/edit/{cardId}")
    public String edit(@PathVariable Integer cardId, ModelMap modelMap) {
        CreditCardEntity creditCardEntity = creditCardService.getById(cardId);
        modelMap.put("creditCard", creditCardEntity);
        return PREFIX + "/edit";
    }

    /**
     * 列表
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public ResultVO list(@RequestParam Map<String, Object> params){
        List<CreditCardEntity> creditCardEntityList = creditCardService.queryList(params);
        return ResultVO.success().put("list", creditCardEntityList);
    }

    /**
     * 跳转到 list
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String toList(HttpSession session, Model model){
        MemberEntity member = (MemberEntity) session.getAttribute("user");
        List<CreditCardEntity> creditCardEntityList = creditCardService.queryListWithMember(member);
        model.addAttribute("creditCardList", creditCardEntityList);
        return PREFIX + "/list";
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{creditCard}")
    public ResultVO info(@PathVariable("creditCard") Long cardId){
        CreditCardEntity creditCardEntity = creditCardService.getById(cardId);
        return ResultVO.success().put("creditCardEntity", creditCardEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
    public ResultVO save(@RequestBody CreditCardEntity creditCardEntity){
        creditCardService.save(creditCardEntity);
        return ResultVO.success();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@RequestBody CreditCardEntity creditCardEntity){
        creditCardService.updateById(creditCardEntity);
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
