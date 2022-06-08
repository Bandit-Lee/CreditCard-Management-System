package com.sys.main;

import com.sys.member.entity.MemberEntity;
import com.sys.member.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Bandit
 * @createTime 2022/6/6 22:32
 */
@Controller
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

    @RequestMapping("/loginConfirm")
    public String loginConfirm(Model model, HttpServletRequest request) {
        String username = (String) model.getAttribute("username");
        String password = (String) model.getAttribute("password");
        MemberEntity memberEntity = memberService.LoginVerification(username, password);
        if (memberEntity != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", memberEntity.getMemberUsername());
            return "index";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "redirct:login";
    }
}
