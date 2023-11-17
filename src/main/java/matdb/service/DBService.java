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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DBService {
    @Autowired
    DBRepository dbRepository;
    @Autowired
    MatRepository matRepository;

    @Transactional
    public void templateSave(TemplateReq templateReq){
        DBEntity db= templateReq.getDbEntity();
        try {
            dbRepository.save(db);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<DBInfoDto> findDBInof(String username){
        List<DBEntity> dbs = dbRepository.findAllByUsername(username);
        List<DBInfoDto> infos = new ArrayList<>();
        for (DBEntity db : dbs) {
            DBInfoDto info = new DBInfoDto();
            BeanUtil.copyProperties(db, info);
            infos.add(info);
        }
        return infos;
    }

    public DBCardDto findDBCard(String id){
        Optional<DBEntity> dbOption = dbRepository.findById(id);
        if (dbOption.isEmpty()){
            return null;
        }
        DBEntity db = dbOption.get();
        DBCardDto card = new DBCardDto();
        BeanUtil.copyProperties(db, card);
        return card;
    }

    @Transactional
    public void changDBCard(ChangeDBCardReq changeDBCardReq){
        DBEntity dbCard = changeDBCardReq.getDbEntity();
        String title = dbCard.getTitle();
        String introduction = dbCard.getIntroduction();
        String id = dbCard.getId();
        Optional<DBEntity> dbOption = dbRepository.findById(id);
        if (dbOption.isEmpty()){
            return;
        }
        DBEntity db = dbOption.get();
        db.setTitle(title);
        db.setIntroduction(introduction);
        try {
            dbRepository.deleteById(id);
            dbRepository.save(db);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void destroy(String uid){
        try {
            matRepository.deleteByUid(uid);
            dbRepository.deleteById(uid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
