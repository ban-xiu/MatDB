package com.matdb.service.impl;

import com.matdb.domain.entity.UserEntity;
import com.matdb.domain.vo.resp.Result;
import com.matdb.enums.UserEnum;
import com.matdb.mapper.repository.UserRepository;
import com.matdb.domain.vo.req.SignAboutReq;
import com.matdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Result<String> signIn(SignAboutReq signInReq) {

        String username = signInReq.getUsername();
        String password = signInReq.getPassword();

        Optional<UserEntity> userOption = userRepository.findByUsername(username);

        String msg;
        if (userOption.isEmpty()) {
            msg = UserEnum.USER_NOT_FOUND.getMessage();
            return Result.error(msg);
        }

        UserEntity user = userOption.get();

        if (!user.getPassword().equals(password)) {
            msg = UserEnum.WRONG_PASSWORD.getMessage();
            return Result.error(msg);
        }

        msg = UserEnum.LOGIN_SUCCESS.getMessage();
        return Result.success(msg);
    }

    @Transactional
    @Override
    public Result<String> signUp(SignAboutReq signUpReq){

        String username = signUpReq.getUsername();
        String password = signUpReq.getPassword();

        Optional<UserEntity> userOption = userRepository.findByUsername(username);

        String msg;
        if (userOption.isPresent()){
            msg = UserEnum.USERNAME_EXISTS.getMessage();
            return Result.error(msg);
        }
        UserEntity user = new UserEntity(null,username,password);
        userRepository.save(user);

        msg = UserEnum.SIGN_UP_SUCCESS.getMessage();
        return Result.success(msg);
    }

    @Transactional
    @Override
    public Result<String> changePassword(SignAboutReq changPwdReq){

        String username = changPwdReq.getUsername();
        String newPassword = changPwdReq.getPassword();

        Optional<UserEntity> userOption = userRepository.findByUsername(username);

        String msg;
        if (userOption.isEmpty()){
            System.out.println("\nchangePassword: null");
            msg = UserEnum.PASSWORD_CHANGED_ERROR.getMessage();
            return Result.error(msg);
        }
        UserEntity user = userOption.get();
        user.setPassword(newPassword);
        try {
            userRepository.save(user);
            msg = UserEnum.PASSWORD_CHANGED_SUCCESS.getMessage();
            return Result.success(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg = UserEnum.PASSWORD_CHANGED_ERROR.getMessage();
            return Result.error(msg);
        }
    }
}
