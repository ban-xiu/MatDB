package com.matdb.service;

import cn.hutool.core.bean.BeanUtil;
import com.matdb.dto.DBCardDto;
import com.matdb.dto.DBInfoDto;
import com.matdb.repository.DBRepository;
import com.matdb.repository.MatRepository;
import com.matdb.req.ChangeDBCardReq;
import com.matdb.entity.DBEntity;

import com.matdb.req.TemplateReq;
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
            System.out.println("\nfindDBCard: null");
            return null;
        }
        DBEntity db = dbOption.get();
        DBCardDto card = new DBCardDto();
        BeanUtil.copyProperties(db, card);
        return card;
    }

    @Transactional
    public void changDBCard(ChangeDBCardReq changeDBCardReq){
        String id = changeDBCardReq.getId();
        Optional<DBEntity> dbOption = dbRepository.findById(id);
        if (dbOption.isEmpty()){
            System.out.println("\nchangDBCard: null");
            return;
        }
        String title = changeDBCardReq.getTitle();
        String introduction = changeDBCardReq.getIntroduction();
        byte[] img = changeDBCardReq.getImg();
        DBEntity db = dbOption.get();
        db.setTitle(title);
        db.setIntroduction(introduction);
        if (img != null) {
            db.setImg(img);
        }
        try {
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
