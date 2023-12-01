package com.matdb.service;

import com.matdb.domain.dto.UserDto;
import com.matdb.domain.vo.req.SignAboutReq;
import com.matdb.domain.vo.resp.Result;


public interface UserService {

    UserDto signIn(SignAboutReq signInReq);


    Result<String> signUp(SignAboutReq signUpReq);


    Result<String> changePassword(SignAboutReq changPwdReq);

}
