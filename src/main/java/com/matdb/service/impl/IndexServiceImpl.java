package com.matdb.service.impl;

import com.matdb.domain.entity.UserEntity;
import com.matdb.mapper.repository.UserRepository;
import com.matdb.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity findUserByUsername(String username){
        Optional<UserEntity> userOption = userRepository.findByUsername(username);
        if (userOption.isEmpty()){
            System.out.println("\nfindUserByUsername: null");
            return null;
        }
        UserEntity user = userOption.get();
        return user;
    }

}
