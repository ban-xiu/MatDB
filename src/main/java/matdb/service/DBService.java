package matdb.service;

import matdb.entity.DBEntity;

import matdb.repository.DBRepository;
import matdb.repository.MatRepository;
import matdb.vo.req.ChangeDBCardReq;
import matdb.vo.req.TemplateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBService {
    @Autowired
    DBRepository dbrepository;
    @Autowired
    MatRepository matrepository;
    public void templateSave(TemplateReq templateReq){
        DBEntity db= templateReq.getDbEntity();
        dbrepository.save(db);
    }

    public List<DBEntity> findDBInof(String username){
        List<DBEntity> dbs = dbrepository.findAllByUsername(username);
        return dbs;
    }

    public DBEntity findDBCard(String id){
        Optional<DBEntity> dbOption = dbrepository.findById(id);
        if (!dbOption.isPresent()){
            return null;
        }
        DBEntity db = dbOption.get();
        return db;
    }
    public void changDBCard(ChangeDBCardReq changeDBCardReq){
        DBEntity dbCard = changeDBCardReq.getDbEntity();
        String title = dbCard.getTitle();
        String introduction = dbCard.getIntroduction();
        String id = dbCard.getId();
        Optional<DBEntity> dbOption = dbrepository.findById(id);
        if (!dbOption.isPresent()){
            return;
        }
        DBEntity db = dbOption.get();
        db.setTitle(title);
        db.setIntroduction(introduction);
        dbrepository.deleteById(id);
        dbrepository.save(db);
    }

    public void destroy(String uid){
        try {
            matrepository.deleteByUid(uid);
            dbrepository.deleteById(uid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
