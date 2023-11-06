package matdb.service;

import matdb.entity.DBentity;

import matdb.repository.DBrepository;
import matdb.repository.Matrepository;
import matdb.req.ChangeDBCrad;
import matdb.req.TemplateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBService {
    @Autowired
    DBrepository dbrepository;
    @Autowired
    Matrepository matrepository;
    public void templateSave(TemplateReq templateReq){
        String title = templateReq.getTitle();
        String introduction= templateReq.getIntroduction();
        String type= templateReq.getType();
        String username= templateReq.getUsername();
        String[] speciality= templateReq.getSpeciality();
        String[] specialityType= templateReq.getSpecialityType();
        DBentity db= new DBentity(null,title,introduction,type,username,speciality,specialityType);
        dbrepository.save(db);
    }

    public List<DBentity> findDBInof(String username){
        List<DBentity> dbentities = dbrepository.findAllByUsername(username);
        return dbentities;
    }

    public DBentity findDBCard(String id){
        Optional<DBentity> dbentity = dbrepository.findById(id);
        if (!dbentity.isPresent()){
            return null;
        }
        return dbentity.get();
    }
    public void changDBCard(ChangeDBCrad changeDBCrad){
        String title = changeDBCrad.getTitle();
        String introduction = changeDBCrad.getIntroduction();
        String id = changeDBCrad.getId();
        Optional<DBentity> dbentity = dbrepository.findById(id);
        if (!dbentity.isPresent()){
            return;
        }
        DBentity db = dbentity.get();
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
