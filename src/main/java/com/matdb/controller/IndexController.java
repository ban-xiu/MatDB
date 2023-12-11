package com.matdb.controller;

import com.matdb.domain.entity.UserEntity;
import com.matdb.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class IndexController {
    @Autowired
    IndexService indexService;

    @GetMapping("/admin")
    public String admin(@RequestParam("username") String username,@RequestParam("key") String key){
        UserEntity user = indexService.findUserByUsername(username);
        String password = user.getPassword();
        String userKey = user.getKey();
        if (Objects.equals(key, userKey)) {
            System.out.println("\nadmin: username:" + username + "/password:" + password + "/key:" + key);
            return "redirect:http://127.0.0.1:8083/admin?username=" + username + "&key=" + key;
        }
        return null;
    }

    @GetMapping("/index")
    public String index(@RequestParam("uid") String uid, @RequestParam("username") String username){
        UserEntity user = indexService.findUserByUsername(username);
        String password = user.getPassword();
        String key = user.getKey();
        System.out.println("\nindex: uid:" + uid + "/username:" + username + "/password:" + password + "/key:" + key);
        return "redirect:http://127.0.0.1:8083/index?uid=" + uid + "&username=" + username;
    }
}
