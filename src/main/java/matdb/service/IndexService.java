package matdb.service;

import matdb.entity.DBEntity;
import matdb.entity.UserEntity;
import matdb.repository.DBRepository;
import matdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndexService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DBRepository dbRepository;

    public String findPassword(String username){
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            return null;
        }
        String password = user.get().getPassword();
        return password;
    }

    public UserEntity findUser(String uid){
        Optional<DBEntity> db = dbRepository.findById(uid);
        if (db.isEmpty()){
            return null;
        }
        String username = db.get().getUsername();
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            return null;
        }
        return user.get();
    }
}
