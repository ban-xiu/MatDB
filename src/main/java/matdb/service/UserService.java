package matdb.service;

import matdb.entity.UserEntity;
import matdb.repository.UserRepository;
import matdb.vo.req.SignAboutReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userrepository;
    public String signIn(SignAboutReq signInReq) {

        String username = signInReq.getUsername();
        String password = signInReq.getPassword();

        Optional<UserEntity> userOption = userrepository.findByUsername(username);

        if (userOption.isEmpty()) {
            return "The user does not exist.";
        }

        UserEntity user = userOption.get();

        if (!user.getPassword().equals(password)) {
            return "Wrong password.";
        }

        // 登录成功
        return "Login succeeded.";
    }
    public String signUp(SignAboutReq signUpReq){

        String username = signUpReq.getUsername();
        String password = signUpReq.getPassword();

        Optional<UserEntity> userOption = userrepository.findByUsername(username);
        if (userOption.isPresent()){
            return "This username is already taken.";
        }
        UserEntity user = new UserEntity(null,username,password);
        userrepository.save(user);
        return "The task has been submitted.";
    }

    public void changePassword(SignAboutReq changPwdReq){

        String username = changPwdReq.getUsername();
        String newPassword = changPwdReq.getPassword();

        Optional<UserEntity> userOption =userrepository.findByUsername(username);
        if (!userOption.isPresent()){
            return;
        }
        UserEntity user = userOption.get();
        user.setPassword(newPassword);
        userrepository.save(user);
    }
}
