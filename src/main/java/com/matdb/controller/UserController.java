package com.matdb.controller;

import com.matdb.domain.vo.req.SignAboutReq;
import com.matdb.domain.vo.resp.Result;
import com.matdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signIn")
    public Result<String> signIn(@RequestBody SignAboutReq signInReq) {
        System.out.println(signInReq.toString());
        return userService.signIn(signInReq);
    }

    @PostMapping("/signUp")
    public Result<String> signUp(@RequestBody SignAboutReq signUpReq){
        System.out.println(signUpReq.toString());
        return userService.signUp(signUpReq);
    }

    @PutMapping("/changePassword")
    public Result<String> changePassword(@RequestBody SignAboutReq changPwdReq){
        System.out.println(changPwdReq.toString());
        return userService.changePassword(changPwdReq);
    }

}
