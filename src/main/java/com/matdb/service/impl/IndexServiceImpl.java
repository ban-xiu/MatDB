package com.matdb.service.impl;

import com.matdb.domain.entity.DBEntity;
import com.matdb.domain.entity.UserEntity;
import com.matdb.mapper.repository.DBRepository;
import com.matdb.mapper.repository.UserRepository;
import com.matdb.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DBRepository dbRepository;

    @Override
    public String findPassword(String username){
        Optional<UserEntity> userOption = userRepository.findByUsername(username);
        if (userOption.isEmpty()){
            System.out.println("\nfindPassword: null");
            return null;
        }
        UserEntity user = userOption.get();
        String password = user.getPassword();
        return password;
    }

}
