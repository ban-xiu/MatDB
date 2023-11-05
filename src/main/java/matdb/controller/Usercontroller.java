package matdb.controller;

import matdb.req.ChangPwdReq;
import matdb.req.SignInReq;
import matdb.req.SignUpReq;
import matdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Usercontroller {
    @Autowired
    UserService userService;
    @PostMapping("/signIn")
    public String signIn(@RequestBody SignInReq signInReq) {
        System.out.println(signInReq.toString());
        return userService.signIn(signInReq);
    }
    @PostMapping("/signUp")
    public String signUp(@RequestBody SignUpReq signUpReq){
        System.out.println(signUpReq.toString());
        return userService.signUp(signUpReq);
    }

    @PutMapping("/changePassword")
    public void changePasswrod(@RequestBody ChangPwdReq changPwdReq){
        System.out.println(changPwdReq.toString());
        userService.changePasswrod(changPwdReq);
    }
}
