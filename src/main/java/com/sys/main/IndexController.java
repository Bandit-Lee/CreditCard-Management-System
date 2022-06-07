package com.sys.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Bandit
 * @createTime 2022/6/6 22:32
 */
@Controller
public class IndexController {

    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }

}
