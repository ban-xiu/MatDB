package com.matdb.service;

import com.matdb.domain.entity.UserEntity;

public interface IndexService {
    UserEntity findUserByUsername(String username);

}
