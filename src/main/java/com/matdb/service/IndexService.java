package com.matdb.service;

import com.matdb.domain.entity.UserEntity;

public interface IndexService {

    String findPassword(String username);

    UserEntity findUser(String uid);

}
