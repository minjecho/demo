package com.fortress.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortress.demo.dto.UserDTO;
import com.fortress.demo.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping({"", "/list"})
    public String userList(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum){
        List<UserDTO> userList = userService.getUserList(pageNum);
        Integer[] pageList = userService.getPageList(pageNum);

        model.addAttribute("userList", userList);
        model.addAttribute("pageList", pageList);

        return "user/list";
    }
}
