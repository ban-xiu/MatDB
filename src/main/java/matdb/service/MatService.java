package matdb.service;

import matdb.entity.MatEntity;

import matdb.repository.MatRepository;
import matdb.vo.req.FileReq;
import matdb.vo.req.SaveReq;
import matdb.vo.req.UpdateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatService {
    @Autowired
    MatRepository matrepository;

    public List<MatEntity> findAll(String uid){
        List<MatEntity> mats = matrepository.findAllByUid(uid);
        return mats;
    }

    public void deleteById(String id){
        matrepository.deleteById(id);
    }


    public void save(SaveReq saveReq){
        MatEntity mat = saveReq.getMatEntity();
        matrepository.save(mat);
    }

    public MatEntity findByCid(String cid){
        Optional<MatEntity> matOption = matrepository.findById(cid);
        MatEntity mat = matOption.get();
        return mat;
    }

    public void update(UpdateReq updateReq){
        MatEntity mat = updateReq.getMatEntity();
        matrepository.deleteById(mat.getId());
        matrepository.save(mat);
    }
    public void addFile(FileReq file){
        MatEntity[] mats = file.getMatEntities();
        System.out.println(mats);
        for (MatEntity mat : mats) {
            matrepository.save(mat);
        }
    }
}
