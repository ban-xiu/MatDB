package com.matdb.service;

import com.matdb.domain.dto.MatDto;
import com.matdb.domain.vo.req.FileReq;
import com.matdb.domain.vo.req.SaveReq;
import com.matdb.domain.vo.req.UpdateReq;

import java.util.List;

public interface MatService {

    List<MatDto> findAll(String uid);

    void deleteById(String id);

    void save(SaveReq saveReq);

    MatDto findByCid(String cid);

    void update(UpdateReq updateReq);

    void addFile(FileReq file);

}
