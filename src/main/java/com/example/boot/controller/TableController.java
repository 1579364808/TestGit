package com.example.boot.controller;

import com.example.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author: LiuLei
 * @date: 2022/8/31 16:54
 * @description:
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
                new User("lisi", "123666"),
                new User("wangwu", "123555"),
                new User("likui", "123444"),
                new User("xiaohong", "123333"));

        model.addAttribute("users", users);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }


}
