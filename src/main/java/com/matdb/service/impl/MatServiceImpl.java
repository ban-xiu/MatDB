package com.matdb.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.matdb.domain.dto.MatDTO;
import com.matdb.domain.entity.MatEntity;
import com.matdb.domain.vo.resp.Result;
import com.matdb.enums.MatEnum;
import com.matdb.mapper.repository.MatRepository;
import com.matdb.domain.vo.req.FileReq;
import com.matdb.domain.vo.req.SaveReq;
import com.matdb.domain.vo.req.UpdateReq;
import com.matdb.service.MatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatServiceImpl implements MatService {
    @Autowired
    MatRepository matRepository;

    @Override
    public List<MatDTO> findAll(String uid){
        List<MatEntity> mats = matRepository.findAllByUid(uid);
        List<MatDTO> matDTOS = new ArrayList<>();
        for (MatEntity mat : mats) {
            MatDTO matDto = new MatDTO();
            BeanUtil.copyProperties(mat, matDto);
            matDTOS.add(matDto);
        }
        return matDTOS;
    }

    @Transactional
    @Override
    public Result<String> deleteById(String id){
        String msg;
        try {
            matRepository.deleteById(id);
            msg = MatEnum.MAT_DELETE_SUCCESS.getMessage();
            return Result.success(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg = MatEnum.MAT_DELETE_ERROR.getMessage();
            return Result.error(msg);
        }
    }

    @Transactional
    @Override
    public Result<String> save(SaveReq saveReq){
        MatEntity mat = saveReq.getMatEntity();

        String msg;
        try {
            matRepository.save(mat);
            msg = MatEnum.MAT_SAVE_SUCCESS.getMessage();
            return Result.success(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg = MatEnum.MAT_SAVE_ERROR.getMessage();
            return Result.error(msg);
        }
    }

    @Override
    public MatDTO findByCid(String cid){
        Optional<MatEntity> matOption = matRepository.findById(cid);
        if (matOption.isEmpty()){
            System.out.println("\nfindByCid: null");
            return null;
        }
        MatEntity mat = matOption.get();
        MatDTO matDto = new MatDTO();
        BeanUtil.copyProperties(mat, matDto);
        return matDto;
    }

    @Transactional
    @Override
    public Result<String> update(UpdateReq updateReq){
        MatEntity update = updateReq.getMatEntity();
        String id = update.getId();
        Optional<MatEntity> matOption = matRepository.findById(id);

        String msg;
        if (matOption.isEmpty()){
            System.out.println("\nupdate: null");
            msg = MatEnum.MAT_NOT_FOUND.getMessage();
            return Result.error(msg);
        }
        MatEntity mat = matOption.get();
        BeanUtil.copyProperties(update, mat);
        try {
            matRepository.save(mat);
            msg = MatEnum.MAT_UPDATE_SUCCESS.getMessage();
            return Result.success(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg = MatEnum.MAT_UPDATE_ERROR.getMessage();
            return Result.error(msg);
        }
    }

    @Transactional
    @Override
    public Result<String> addFile(FileReq file){
        MatEntity[] mats = file.getMatEntities();

        String msg;
        try {
            for (MatEntity mat : mats) {
                matRepository.save(mat);
            }
            msg = MatEnum.MAT_ADD_FILE_SUCCESS.getMessage();
            return Result.success(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg = MatEnum.MAT_ADD_FILE_ERROR.getMessage();
            return Result.error(msg);
        }
    }

}
