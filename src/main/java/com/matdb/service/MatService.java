package com.matdb.service;

import com.matdb.domain.dto.MatDto;
import com.matdb.domain.vo.req.FileReq;
import com.matdb.domain.vo.req.SaveReq;
import com.matdb.domain.vo.req.UpdateReq;
import com.matdb.domain.vo.resp.Result;

import java.util.List;

public interface MatService {

    List<MatDto> findAll(String uid);

    Result<String> deleteById(String id);

    Result<String> save(SaveReq saveReq);

    MatDto findByCid(String cid);

    Result<String> update(UpdateReq updateReq);

    Result<String> addFile(FileReq file);

}
