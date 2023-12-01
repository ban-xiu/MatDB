package com.matdb.controller;

import com.matdb.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
    @Autowired
    IndexService indexService;

    @GetMapping("/")
    public String login(){
        System.out.println("\nlogin");
        return "login";
    }
    @GetMapping("/admin")
    public String admin(@RequestParam("username") String username, Model model){
        String password = indexService.findPassword(username);
        model.addAttribute("username", username);
        model.addAttribute("password",password);
        System.out.println("\nadmin: username:" + username + "password:" + password);
        return "admin";
    }

    @GetMapping("/register")
    public String register(){
        System.out.println("\nregister");
        return "register";
    }
    
    @GetMapping("/index")
    public String index(@RequestParam("uid") String uid, @RequestParam("username") String username, Model model){
        String password = indexService.findPassword(username);
        model.addAttribute("uid",uid);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        System.out.println("\nindex: uid:" + uid + "username:" + username + "password:" + password);
        return "index";
    }
}
