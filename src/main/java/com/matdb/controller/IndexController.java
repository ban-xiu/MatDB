package com.matdb.controller;

import com.matdb.domain.entity.UserEntity;
import com.matdb.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

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
    public String admin(@RequestParam("username") String username,@RequestParam("key") String key, Model model){
        UserEntity user = indexService.findUserByUsername(username);
        String password = user.getPassword();
        String userKey = user.getKey();
        if (Objects.equals(key, userKey)) {
            model.addAttribute("username", username);
            model.addAttribute("password",password);
            model.addAttribute("key",key);
            System.out.println("\nadmin: username:" + username + "/password:" + password + "/key:" + key);
            return "admin";
        }
        return null;
    }


    @GetMapping("/register")
    public String register(){
        System.out.println("\nregister");
        return "register";
    }

    @GetMapping("/index")
    public String index(@RequestParam("uid") String uid, @RequestParam("username") String username, Model model){
        UserEntity user = indexService.findUserByUsername(username);
        String password = user.getPassword();
        String key = user.getKey();
        model.addAttribute("uid",uid);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        model.addAttribute("key",key);
        System.out.println("\nindex: uid:" + uid + "/username:" + username + "/password:" + password + "/key:" + key);
        return "index";
    }
}
