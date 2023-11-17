package matdb.service;

import matdb.entity.UserEntity;
import matdb.repository.UserRepository;
import matdb.req.SignAboutReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String signIn(SignAboutReq signInReq) {

        String username = signInReq.getUsername();
        String password = signInReq.getPassword();

        Optional<UserEntity> userOption = userRepository.findByUsername(username);

        if (userOption.isEmpty()) {
            return "The user does not exist.";
        }

        UserEntity user = userOption.get();

        if (!user.getPassword().equals(password)) {
            return "Wrong password.";
        }

        return "Login succeeded.";
    }

    @Transactional
    public String signUp(SignAboutReq signUpReq){

        String username = signUpReq.getUsername();
        String password = signUpReq.getPassword();

        Optional<UserEntity> userOption = userRepository.findByUsername(username);
        if (userOption.isPresent()){
            return "This username is already taken.";
        }
        UserEntity user = new UserEntity(null,username,password);
        userRepository.save(user);
        return "The task has been submitted.";
    }

    @Transactional
    public void changePassword(SignAboutReq changPwdReq){

        String username = changPwdReq.getUsername();
        String newPassword = changPwdReq.getPassword();

        Optional<UserEntity> userOption = userRepository.findByUsername(username);
        if (userOption.isEmpty()){
            return;
        }
        UserEntity user = userOption.get();
        user.setPassword(newPassword);
        try {
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
