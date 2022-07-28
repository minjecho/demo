package com.fortress.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fortress.demo.service.UserService;
import com.fortress.demo.vo.UserVO;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/userList")
    public ModelAndView userAllList() throws Exception{
        ModelAndView mv = new ModelAndView("/userList");
        List<UserVO> list = userService.selectUserList();
        mv.addObject("list", list);
        mv.setViewName("user/userList");

        return mv;
    }
}
