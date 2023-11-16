package matdb.service;

import matdb.entity.UserEntity;
import matdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndexService {
    @Autowired
    UserRepository userRepository;

    public String findPassword(String username){
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (!user.isPresent()){
            return null;
        }
        String password = user.get().getPassword();
        return password;
    }

}
