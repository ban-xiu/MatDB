package com.matdb.service;

import com.matdb.domain.dto.DBCardDto;
import com.matdb.domain.dto.DBInfoDto;
import com.matdb.domain.vo.req.ChangeDBCardReq;

import com.matdb.domain.vo.req.TemplateReq;
import com.matdb.domain.vo.resp.Result;

import java.util.List;

public interface DBService {

    Result<String> templateSave(TemplateReq templateReq);

    List<DBInfoDto> findDBInof();

    DBCardDto findDBCard(String id);

    Result<String> changDBCard(ChangeDBCardReq changeDBCardReq);

    Result<String> destroy(String uid);

}
