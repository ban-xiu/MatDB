package matdb.repository;

import matdb.entity.DBentity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DBrepository extends MongoRepository<DBentity,String> {
    List<DBentity> findAllByUsername(String username);
}
