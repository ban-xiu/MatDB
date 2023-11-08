package matdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
    @GetMapping("/")
    public String login(){
        return "login";
    }
    @GetMapping("/admin")
    public String admin(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        model.addAttribute("username", username);
        model.addAttribute("password",password);
        return "admin";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/index")
    public String index(@RequestParam("uid") String uid,@RequestParam("username") String username,@RequestParam("password") String password, Model model){
        model.addAttribute("uid",uid);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "index";
    }
}
