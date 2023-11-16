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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatService {
    @Autowired
    MatRepository matRepository;

    public List<MatDto> findAll(String uid){
        List<MatEntity> allMatList = matRepository.findAllByUid(uid);
        List<MatDto> mats = new ArrayList<>();
        for (MatEntity oneMat : allMatList) {
            MatDto mat = new MatDto();
            BeanUtil.copyProperties(oneMat, mat);
            mats.add(mat);
        }
        return mats;
    }

    public void deleteById(String id){
        try {
            matRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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
        MatEntity oneMat = matOption.get();
        MatDto mat = new MatDto();
        BeanUtil.copyProperties(oneMat, mat);
        return mat;
    }

    public void update(UpdateReq updateReq){
        MatEntity mat = updateReq.getMatEntity();
        try {
            matRepository.deleteById(mat.getId());
            matRepository.save(mat);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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
