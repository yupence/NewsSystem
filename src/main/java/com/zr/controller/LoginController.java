package com.zr.controller;

import com.zr.po.User;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String toLogin(){
        return "admin/login";
    }

    @PostMapping("login")
    public String login(String username, String password, HttpSession session, RedirectAttributes redirectAttributes){
        User user = userService.checkUser(username,password);
        if(user!=null){
            session.setAttribute("user",user);
            return "admin/index";
        }else{
            redirectAttributes.addFlashAttribute("message","用户名密码错误");
            return "redirect:/admin";
        }
    }
    @PostMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "admin/login";

    }
}