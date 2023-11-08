package matdb.repository;

import matdb.entity.MatEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatRepository extends MongoRepository<MatEntity, String> {
    List<MatEntity> findAllByUid(String uid);
    void deleteByUid(String uid);
}

