package matdb.service;

import matdb.entity.Matentity;

import matdb.repository.Matrepository;
import matdb.req.UpdateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatService {
    @Autowired
    Matrepository matrepository;

    public List<Matentity> findAll(String uid){
        List<Matentity> matentities = matrepository.findAllByUid(uid);
        return matentities;
    }

    public void deleteById(String id){
        matrepository.deleteById(id);
    }


    public void save(Matentity matentity){
        matrepository.save(matentity);
    }

    public String findByCid(String cid){
        Optional<Matentity> mat = matrepository.findById(cid);
        return mat.get().toJson();
    }

    public void update(UpdateReq updateReq){
        Matentity mat = updateReq.getMatentity();
        matrepository.deleteById(mat.getId());
        matrepository.save(mat);
    }
    public void addFile(Matentity[] file){
        for (Matentity matentity : file) {
            matrepository.save(matentity);
        }
    }
}
