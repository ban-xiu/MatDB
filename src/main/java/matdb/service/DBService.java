package matdb.service;

import cn.hutool.core.bean.BeanUtil;
import matdb.dto.DBCardDto;
import matdb.dto.DBInfoDto;
import matdb.entity.DBEntity;

import matdb.repository.DBRepository;
import matdb.repository.MatRepository;
import matdb.req.ChangeDBCardReq;
import matdb.req.TemplateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        try {
            dbrepository.save(db);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<DBInfoDto> findDBInof(String username){
        List<DBEntity> dbs = dbrepository.findAllByUsername(username);
        List<DBInfoDto> infos = new ArrayList<>();
        for (DBEntity db : dbs) {
            DBInfoDto info = new DBInfoDto();
            BeanUtil.copyProperties(db, info);
            infos.add(info);
        }
        return infos;
    }

    public DBCardDto findDBCard(String id){
        Optional<DBEntity> dbOption = dbrepository.findById(id);
        if (!dbOption.isPresent()){
            return null;
        }
        DBEntity db = dbOption.get();
        DBCardDto card = new DBCardDto();
        BeanUtil.copyProperties(db, card);
        return card;
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
        try {
            dbrepository.deleteById(id);
            dbrepository.save(db);
        }catch (Exception e){
            e.printStackTrace();
        }
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
