package com.fortress.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/main")
    public String getMessage(Model model){
        model.addAttribute("testSTR", "이제부터는 타임리프를 사용하세요.");
        return "mainHome";
    }
}
