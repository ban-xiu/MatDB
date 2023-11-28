package com.matdb.service;

import com.matdb.domain.dto.DBCardDto;
import com.matdb.domain.dto.DBInfoDto;
import com.matdb.domain.vo.req.ChangeDBCardReq;

import com.matdb.domain.vo.req.TemplateReq;

import java.util.List;

public interface DBService {

    void templateSave(TemplateReq templateReq);

    List<DBInfoDto> findDBInof(String username);

    DBCardDto findDBCard(String id);

    void changDBCard(ChangeDBCardReq changeDBCardReq);

    void destroy(String uid);

}
