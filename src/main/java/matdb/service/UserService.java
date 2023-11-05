package matdb.service;

import matdb.entity.Userentity;
import matdb.repository.Userrepository;
import matdb.req.ChangPwdReq;
import matdb.req.SignInReq;
import matdb.req.SignUpReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    Userrepository userrepository;
    public String signIn(SignInReq signInReq) {

        String username = signInReq.getUsername();
        String password = signInReq.getPassword();

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
    public String signUp(SignUpReq signUpReq){

        String username = signUpReq.getUsername();
        String password = signUpReq.getPassword();

        Optional<Userentity> userOptional = userrepository.findByUsername(username);
        if (userOptional.isPresent()){
            return "This username is already taken.";
        }
        Userentity userentity =new Userentity(null,username,password);
        userrepository.save(userentity);
        return "The task has been submitted.";
    }

    public void changePasswrod(ChangPwdReq changPwdReq){

        String username = changPwdReq.getUsername();
        String newPassword = changPwdReq.getNewPassword();

        Optional<Userentity> userOptional=userrepository.findByUsername(username);
        Userentity user = userOptional.get();
        user.setPassword(newPassword);
        userrepository.save(user);
    }
}
