package matdb.repository;

import matdb.entity.Userentity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepository extends MongoRepository<Userentity,String> {
    Optional<Userentity> findByUsername(String username);
}
