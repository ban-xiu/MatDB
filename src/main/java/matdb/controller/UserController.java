package matdb.controller;

import matdb.req.SignAboutReq;
import matdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signIn")
    public String signIn(@RequestBody SignAboutReq signInReq) {
        System.out.println(signInReq.toString());
        return userService.signIn(signInReq);
    }
    @PostMapping("/signUp")
    public String signUp(@RequestBody SignAboutReq signUpReq){
        System.out.println(signUpReq.toString());
        return userService.signUp(signUpReq);
    }

    @PutMapping("/changePassword")
    public void changePassword(@RequestBody SignAboutReq changPwdReq){
        System.out.println(changPwdReq.toString());
        userService.changePassword(changPwdReq);
    }
}
