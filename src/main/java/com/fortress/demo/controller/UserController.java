package com.fortress.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fortress.demo.service.UserService;
import com.fortress.demo.vo.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 전체 유저 조회
    @GetMapping("/list")
    public ModelAndView userAllList() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserVO> list = userService.selectUserList();
        mv.addObject("list", list);
        mv.setViewName("user/userList");

        return mv;
    }

    // 유저 검색
    @PostMapping
    public ModelAndView searchUserList() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserVO> list = userService.searchUserList();

        mv.addObject("list", list);
        mv.setViewName("user/userList");

        return mv;
    }
}
