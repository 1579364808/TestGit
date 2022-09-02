package com.example.boot.controller;

import com.example.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author: LiuLei
 * @date: 2022/8/31 15:18
 * @description:
 */

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }


    /*为了防止表单的重复提交   需要进行重定向*/
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUserName())&&"123456".equals(user.getPassword())){
            //把登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            return "redirect:main.html";//登录成功  重定向到main页面
        }else {
            model.addAttribute("msg", "账号密码错误");
            //回到登录页面
            return "login";
        }


    }
    //刷新就等于是这个请求(这个不能少，不是static目录下文件)
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //是否登录。 拦截器，过滤器
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }else {
            model.addAttribute("msg", "当前未登录");
            return "login";
        }
    }
}
