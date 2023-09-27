package matdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Indexcontroller {
    @RequestMapping("/")
    public String login(){
        return "login";
    }
    @RequestMapping("/admin")
    public String admin(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        model.addAttribute("username", username);
        model.addAttribute("password",password);
        return "admin";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/index")
    public String index(@RequestParam("uid") String uid,@RequestParam("username") String username,@RequestParam("password") String password, Model model){
        model.addAttribute("uid",uid);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "index";
    }
}
