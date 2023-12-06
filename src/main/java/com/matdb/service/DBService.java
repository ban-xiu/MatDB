package com.matdb.service;

import com.matdb.domain.dto.DBCardDTO;
import com.matdb.domain.dto.DBInfoDTO;
import com.matdb.domain.vo.req.ChangeDBCardReq;

import com.matdb.domain.vo.req.TemplateReq;
import com.matdb.domain.vo.resp.Result;

import java.util.List;

public interface DBService {

    Result<String> templateSave(TemplateReq templateReq);

    List<DBInfoDTO> findDBInof();

    DBCardDTO findDBCard(String id);

    Result<String> changDBCard(ChangeDBCardReq changeDBCardReq);

    Result<String> destroy(String uid);

}
