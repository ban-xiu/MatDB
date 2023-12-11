package com.matdb.service;

import com.matdb.domain.dto.UserDTO;
import com.matdb.domain.vo.req.SignAboutReq;
import com.matdb.domain.vo.resp.Result;


public interface UserService {

    UserDTO signIn(SignAboutReq signInReq);


    Result<String> signUp(SignAboutReq signUpReq);


    Result<String> changePassword(SignAboutReq changPwdReq);

    String getKeyByUsername(String username);

    String getPasswordByUsername(String username);
}
