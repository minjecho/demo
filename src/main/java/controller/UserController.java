package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/userList")
    public String userList(Model model){
        String data = "User List 페이지 표시 완료";
        model.addAttribute("data", data);
        return "userList";
    }
}
