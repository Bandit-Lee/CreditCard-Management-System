package com.sys.main;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.sys.member.entity.MemberEntity;
import com.sys.member.service.impl.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Bandit
 * @createTime 2022/6/6 22:32
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    MemberServiceImpl memberService;

    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/loginConfirm")
    public String loginConfirm(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model,
                               HttpServletRequest request) {
        log.info("username:[{}], password:[{}]", username, password);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.addAttribute("msg","用户名或密码为空");
            return "redirect:login";
        }
        MemberEntity memberEntity = memberService.loginVerification(username, password);
        if (memberEntity != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", memberEntity);
            log.info("session存入用户:[{}]", memberEntity);
            return "redirect:index";
        }
        log.info("用户名或密码错误");
        model.addAttribute("msg","用户名或密码错误");
        return "redirect:login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:index";
    }
}
