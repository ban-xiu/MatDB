package com.matdb.mapper.repository;

import com.matdb.domain.entity.DBEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DBRepository extends MongoRepository<DBEntity,String> {

}
