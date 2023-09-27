package matdb.repository;

import matdb.entity.Matentity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Matrepository  extends MongoRepository<Matentity, String> {
    List<Matentity> findAllByUid(String uid);
    void deleteByUid(String uid);
}

