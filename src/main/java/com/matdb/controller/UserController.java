package com.matdb.controller;

import com.matdb.domain.dto.KeyAndPwdDTO;
import com.matdb.domain.dto.UserDTO;
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
    public Result<UserDTO> signIn(@RequestBody SignAboutReq signInReq) {
        System.out.println("\nsignIn:" + signInReq.toString());
        UserDTO userDto = userService.signIn(signInReq);
        return Result.success(userDto);
    }

    @PostMapping("/signUp")
    public Result<String> signUp(@RequestBody SignAboutReq signUpReq){
        System.out.println("\nsignUp:" + signUpReq.toString());
        return userService.signUp(signUpReq);
    }

    @PutMapping("/changePassword")
    public Result<String> changePassword(@RequestBody SignAboutReq changPwdReq){
        System.out.println("\nchangePassword:" + changPwdReq.toString());
        return userService.changePassword(changPwdReq);
    }

    @GetMapping("/getKey")
    public Result<String> getKeyByUsername(@RequestParam("username") String username){
        System.out.println("\ngetKey:" + username);
        String key = userService.getKeyByUsername(username);
        return Result.success(key);
    }

    @GetMapping("/getKeyAndPassword")
    public Result<KeyAndPwdDTO> getKeyAndPasswordByUsername(@RequestParam("username") String username){
        System.out.println("\ngetKeyAndPassword:" + username);
        KeyAndPwdDTO keyAndPwdDTO = userService.getKeyAndPasswordByUsername(username);
        return Result.success(keyAndPwdDTO);
    }

    @GetMapping("/isUid")
    public Result<Boolean> isUid(@RequestParam("uid") String uid){
        System.out.println("\nisUid:" + uid);
        Boolean flag = userService.findUid(uid);
        return Result.success(flag);
    }

}
