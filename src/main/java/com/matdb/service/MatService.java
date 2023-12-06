package com.matdb.service;

import com.matdb.domain.dto.MatDTO;
import com.matdb.domain.vo.req.FileReq;
import com.matdb.domain.vo.req.SaveReq;
import com.matdb.domain.vo.req.UpdateReq;
import com.matdb.domain.vo.resp.Result;

import java.util.List;

public interface MatService {

    List<MatDTO> findAll(String uid);

    Result<String> deleteById(String id);

    Result<String> save(SaveReq saveReq);

    MatDTO findByCid(String cid);

    Result<String> update(UpdateReq updateReq);

    Result<String> addFile(FileReq file);

}
