package com.matdb.service;

import cn.hutool.core.bean.BeanUtil;
import com.matdb.dto.MatDto;
import com.matdb.entity.MatEntity;
import com.matdb.repository.MatRepository;
import com.matdb.req.FileReq;
import com.matdb.req.SaveReq;
import com.matdb.req.UpdateReq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatService {
    @Autowired
    MatRepository matRepository;

    public List<MatDto> findAll(String uid){
        List<MatEntity> mats = matRepository.findAllByUid(uid);
        List<MatDto> matDtos = new ArrayList<>();
        for (MatEntity mat : mats) {
            MatDto matDto = new MatDto();
            BeanUtil.copyProperties(mat, matDto);
            matDtos.add(matDto);
        }
        return matDtos;
    }

    @Transactional
    public void deleteById(String id){
        try {
            matRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void save(SaveReq saveReq){
        MatEntity mat = saveReq.getMatEntity();
        try {
            matRepository.save(mat);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MatDto findByCid(String cid){
        Optional<MatEntity> matOption = matRepository.findById(cid);
        if (matOption.isEmpty()){
            System.out.println("\nfindByCid: null");
            return null;
        }
        MatEntity mat = matOption.get();
        MatDto matDto = new MatDto();
        BeanUtil.copyProperties(mat, matDto);
        return matDto;
    }

    @Transactional
    public void update(UpdateReq updateReq){
        MatEntity update = updateReq.getMatEntity();
        String id = update.getId();
        Optional<MatEntity> matOption = matRepository.findById(id);
        if (matOption.isEmpty()){
            System.out.println("\nupdate: null");
            return;
        }
        MatEntity mat = matOption.get();
        BeanUtil.copyProperties(update, mat);
        try {
            matRepository.save(mat);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void addFile(FileReq file){
        MatEntity[] mats = file.getMatEntities();
        try {
            for (MatEntity mat : mats) {
                matRepository.save(mat);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
