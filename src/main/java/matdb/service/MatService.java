package matdb.service;

import cn.hutool.core.bean.BeanUtil;
import matdb.dto.MatDto;
import matdb.entity.MatEntity;

import matdb.repository.MatRepository;
import matdb.req.FileReq;
import matdb.req.SaveReq;
import matdb.req.UpdateReq;
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
        MatEntity mat = matOption.get();
        MatDto matDto = new MatDto();
        BeanUtil.copyProperties(mat, matDto);
        return matDto;
    }

    @Transactional
    public void update(UpdateReq updateReq){
        MatEntity mat = updateReq.getMatEntity();
        try {
            matRepository.deleteById(mat.getId());
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
