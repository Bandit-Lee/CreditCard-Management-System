package com.sys.credit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.common.entity.ResultVO;
import com.common.utils.CardImageStoreUtils;
import com.sys.credit.entity.CardPublisherEntity;
import com.sys.credit.entity.CardTypeEntity;
import com.sys.credit.service.impl.CardPublisherServiceImpl;
import com.sys.credit.service.impl.CardServiceImpl;
import com.sys.credit.service.impl.CardTypeServiceImpl;
import com.sys.credit.vo.CardVO;
import com.sys.member.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.sys.credit.entity.CardEntity;

import javax.servlet.http.HttpSession;

/**
 *
 * @author bandit
 * @email ldslee@qq.com
 * @date 2022-06-10 11:46:51
 */
@Controller
@RequestMapping("/credit")
public class CardController {

    private static final String PREFIX= "/credit";

    @Autowired
    CardServiceImpl creditCardService;

    @Autowired
    CardPublisherServiceImpl cardPublisherService;

    @Autowired
    CardTypeServiceImpl creditTypeService;

    @GetMapping("/card")
    public String card(Model model) {
        List<CardEntity> list = creditCardService.queryList(null);
        model.addAttribute("creditCardList", list);
        return PREFIX + "/card";
    }

    @GetMapping("/toAdd")
    public String add(Model model) {
        List<CardTypeEntity> typeEntityList = creditTypeService.queryList(null);
        List<CardPublisherEntity> publisherList = cardPublisherService.list();
        model.addAttribute("typeList", typeEntityList);
        model.addAttribute("publisherList", publisherList);
        return PREFIX + "/add";
    }

    @GetMapping("/edit/{cardId}")
    public String edit(@PathVariable Long cardId, ModelMap modelMap) {
        CardVO cardEntity = creditCardService.getCardById(cardId);
        List<CardPublisherEntity> cardPublisherList = cardPublisherService.list();
        modelMap.put("creditCard", cardEntity);
        modelMap.put("cardPublisherList", cardPublisherList);
        return PREFIX + "/edit";
    }

    @PostMapping("/toAddInfo")
    public String addInfo(@RequestParam Long cardType,
                          @RequestParam Long cardPublisher,
                          Model model) {
        CardTypeEntity cardTypeEntity = creditTypeService.getById(cardType);
        CardPublisherEntity cardPublisherEntity = cardPublisherService.getById(cardPublisher);
        CardEntity cardEntity = CardEntity.builder()
                .cardType(cardType)
                .cardPublisher(cardPublisher)
                .goldFlag(0).build();
        String transform = CardImageStoreUtils.transform(cardEntity);
        String url = CardImageStoreUtils.getUrl(transform);
        model.addAttribute("url",url);
        model.addAttribute("type",cardTypeEntity);
        model.addAttribute("publisher",cardPublisherEntity);
        return PREFIX + "/add-info";
    }

    /**
     * ????????? list
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

    @RequestMapping("/toUpgrade/{cardId}")
    public String toUpgrade(@PathVariable Long cardId, Model model) {
        CardVO creditCard = creditCardService.getCardById(cardId);
        List<CardTypeEntity> typeList = creditTypeService.list();
        model.addAttribute("creditCard",creditCard);
        model.addAttribute("typeList",typeList);
        return PREFIX + "/upgrade";
    }

    @RequestMapping("/toVerify")
    public String toVerify(Model model) {
        List<CardVO> list = creditCardService.queryAllListUnVerified();
        model.addAttribute("cardList",list);
        return PREFIX + "/verify";
    }

    /**
     * ??????
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam Map<String, Object> params){
        List<CardEntity> cardEntityList = creditCardService.queryList(params);
        return ResultVO.success().put("list", cardEntityList);
    }

    /**
     * ??????
     */
    @RequestMapping("/info/{creditCard}")
    public ResultVO info(@PathVariable("creditCard") Long cardId){
        CardEntity creditCardEntity = creditCardService.getById(cardId);
        return ResultVO.success().put("creditCardEntity", creditCardEntity);
    }

    /**
     * ??????
     */
    @RequestMapping("/save")
    @ResponseBody
    public ResultVO save(@RequestBody CardVO cardVO){
        creditCardService.saveCascade(cardVO);
        return ResultVO.success();
    }

    @RequestMapping("/upgrade")
    @ResponseBody
    public ResultVO upgrade(@RequestBody Long cardId) {
        creditCardService.upgradeCardLevel(cardId);
        return ResultVO.success();
    }

    @RequestMapping("/verify/{cardId}/{flag}")
    @ResponseBody
    public ResultVO verify(@PathVariable Long cardId, @PathVariable Integer flag) {
        creditCardService.verifyCardById(cardId, flag);
        return ResultVO.success();
    }

    /**
     * ??????
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@RequestBody CardEntity cardEntity){
        creditCardService.updateById(cardEntity);
        return ResultVO.success();
    }

    /**
     * ??????
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultVO delete(@RequestBody Long[] creditCardIds){
        creditCardService.removeByIds(Arrays.asList(creditCardIds));
        return ResultVO.success();
    }
}
