package com.matdb.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.matdb.domain.dto.UserDTO;
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

    private static int keyLength = 30;

    @Override
    public UserDTO signIn(SignAboutReq signInReq) {

        String username = signInReq.getUsername();
        String password = signInReq.getPassword();

        Optional<UserEntity> userOption = userRepository.findByUsername(username);

        String msg;
        UserDTO userDto = new UserDTO();
        if (userOption.isEmpty()) {
            msg = UserEnum.USER_NOT_FOUND.getMessage();
            userDto.setMsg(msg);
            return userDto;
        }

        UserEntity user = userOption.get();

        if (!user.getPassword().equals(password)) {
            msg = UserEnum.WRONG_PASSWORD.getMessage();
            userDto.setMsg(msg);
            return userDto;
        }

        msg = UserEnum.LOGIN_SUCCESS.getMessage();
        userDto.setMsg(msg);
        userDto.setUsername(username);
        userDto.setPassword(password);
        String randomKey = RandomUtil.randomString(keyLength);
        userDto.setKey(randomKey);
        user.setKey(randomKey);
        userRepository.save(user);
        return userDto;
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
        UserEntity user = new UserEntity(null,username,password,null);
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

    @Override
    public String getKeyByUsername(String username) {
        Optional<UserEntity> userOption = userRepository.findByUsername(username);
        if (userOption.isEmpty()){
            System.out.println("\ngetKeyByUsername: null");
            return null;
        }
        UserEntity user = userOption.get();
        String key = user.getKey();
        return key;
    }

    @Override
    public String getPasswordByUsername(String username) {
        Optional<UserEntity> userOption = userRepository.findByUsername(username);
        if (userOption.isEmpty()){
            System.out.println("\ngetPasswordByUsername: null");
            return null;
        }
        UserEntity user = userOption.get();
        String password = user.getPassword();
        return password;
    }

}
