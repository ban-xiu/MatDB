package com.matdb.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.matdb.domain.dto.DBCardDto;
import com.matdb.domain.dto.DBInfoDto;
import com.matdb.domain.entity.DBEntity;
import com.matdb.domain.vo.resp.Result;
import com.matdb.enums.DBEnum;
import com.matdb.mapper.repository.DBRepository;
import com.matdb.mapper.repository.MatRepository;
import com.matdb.domain.vo.req.ChangeDBCardReq;
import com.matdb.domain.vo.req.TemplateReq;
import com.matdb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DBServiceImpl implements DBService {
    @Autowired
    DBRepository dbRepository;

    @Autowired
    MatRepository matRepository;

    @Transactional
    @Override
    public Result<String> templateSave(TemplateReq templateReq){
        DBEntity db= templateReq.getDbEntity();

        String msg;
        try {
            dbRepository.save(db);
            msg = DBEnum.DB_TEMPLATE_SAVE_SUCCESS.getMessage();
            return Result.success(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg = DBEnum.DB_TEMPLATE_SAVE_ERROR.getMessage();
            return Result.error(msg);
        }
    }

    @Override
    public List<DBInfoDto> findDBInof(){
        List<DBEntity> dbs = dbRepository.findAll();
        List<DBInfoDto> infos = new ArrayList<>();
        for (DBEntity db : dbs) {
            DBInfoDto info = new DBInfoDto();
            BeanUtil.copyProperties(db, info);
            infos.add(info);
        }
        return infos;
    }

    @Override
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
    @Override
    public Result<String> changDBCard(ChangeDBCardReq changeDBCardReq){
        String id = changeDBCardReq.getId();
        Optional<DBEntity> dbOption = dbRepository.findById(id);

        String msg;
        if (dbOption.isEmpty()){
            System.out.println("\nchangDBCard: null");
            msg = DBEnum.DB_CARD_NOT_FOUND.getMessage();
            return Result.error(msg);
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
            msg = DBEnum.DB_CARD_UPDATE_SUCCESS.getMessage();
            return Result.success(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg = DBEnum.DB_CARD_UPDATE_ERROR.getMessage();
            return Result.error(msg);
        }
    }

    @Transactional
    @Override
    public Result<String> destroy(String uid){
        String msg;
        try {
            matRepository.deleteByUid(uid);
            dbRepository.deleteById(uid);
            msg = DBEnum.DB_BURN_SUCCESS.getMessage();
            return Result.success(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg = DBEnum.DB_BURN_ERROR.getMessage();
            return Result.error(msg);
        }
    }
}
