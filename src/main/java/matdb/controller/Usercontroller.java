package matdb.controller;

import matdb.entity.Userentity;
import matdb.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Usercontroller {
    @Autowired
    Userrepository userrepository;
    @RequestMapping("/signIn")
    public String signIn(@RequestParam("username") String username, @RequestParam("password") String password) {

        Optional<Userentity> userOptional = userrepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            return "The user does not exist.";
        }

        Userentity user = userOptional.get();

        if (!user.getPassword().equals(password)) {
            return "Wrong password.";
        }

        // 登录成功
        return "Login succeeded.";
    }
    @RequestMapping("/signUp")
    public String signUp(@RequestParam("username") String username,@RequestParam("password") String password){
        Optional<Userentity> userOptional = userrepository.findByUsername(username);
        if (userOptional.isPresent()){
            return "This username is already taken.";
        }
        Userentity userentity =new Userentity(null,username,password);
        userrepository.save(userentity);
        return "The task has been submitted.";
    }

    @RequestMapping("/changePassword")
    public void changePasswrod(@RequestParam("username") String username,@RequestParam("newPassword") String newPassword){
        Optional<Userentity> userOptional=userrepository.findByUsername(username);
        Userentity user = userOptional.get();
        user.setPassword(newPassword);
        userrepository.save(user);
    }
}
