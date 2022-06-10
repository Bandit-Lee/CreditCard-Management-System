package com.sys.credit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.common.entity.ResultVO;
import com.sys.credit.entity.CardEntity;
import com.sys.credit.service.impl.CardServiceImpl;
import com.sys.credit.service.impl.CardTypeServiceImpl;
import com.sys.credit.vo.CardVO;
import com.sys.member.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.sys.credit.entity.CardTypeEntity;
import com.sys.credit.service.CardTypeService;

import javax.servlet.http.HttpSession;


/**
 *
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:42:50
 */
@RestController
@RequestMapping("credit/cardtype")
public class CardTypeController {

    private static final String PREFIX= "/credit";

    @Autowired
    CardServiceImpl creditCardService;

    @Autowired
    CardTypeServiceImpl creditTypeService;

    @GetMapping("/card")
    public String creditCard(ModelMap modelMap) {
        List<CardEntity> list = creditCardService.queryList(null);
        modelMap.put("creditCardList", list);
        return PREFIX + "/card";
    }

    @GetMapping("/toAdd")
    public String add(Model model) {
        List<CardTypeEntity> typeEntityList = creditTypeService.queryList(null);
        model.addAttribute("typeList", typeEntityList);
        return PREFIX + "/add";
    }

    @GetMapping("/edit/{cardId}")
    public String edit(@PathVariable Long cardId, ModelMap modelMap) {
        CardVO cardEntity = creditCardService.getCardById(cardId);
        modelMap.put("creditCard", cardEntity);
        return PREFIX + "/edit";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam Map<String, Object> params){
        List<CardEntity> cardEntityList = creditCardService.queryList(params);
        return ResultVO.success().put("list", cardEntityList);
    }

    /**
     * 跳转到 list
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model){
        MemberEntity member = (MemberEntity) session.getAttribute("user");
        List<CardVO> creditCardEntityList = creditCardService.queryListWithMember(member);
        model.addAttribute("creditCardList", creditCardEntityList);
        return PREFIX + "/list";
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{creditCard}")
    public ResultVO info(@PathVariable("creditCard") Long cardId){
        CardEntity creditCardEntity = creditCardService.getById(cardId);
        return ResultVO.success().put("creditCardEntity", creditCardEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
    public ResultVO save(@RequestBody CardEntity cardEntity){
        creditCardService.save(cardEntity);
        return ResultVO.success();
    }

    @RequestMapping("/toUpgrade/{cardId}")
    public String toUpgrade(@PathVariable Long cardId, Model model) {
        CardVO creditCard = creditCardService.getCardById(cardId);
        List<CardTypeEntity> typeList = creditTypeService.list();
        model.addAttribute("creditCard",creditCard);
        model.addAttribute("typeList",typeList);
        return PREFIX + "/upgrade";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@RequestBody CardEntity cardEntity){
        creditCardService.updateById(cardEntity);
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
