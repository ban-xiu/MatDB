package matdb.controller;

import com.google.gson.Gson;
import matdb.entity.Matentity;
import matdb.entity.Matentitylist;
import matdb.repository.Matrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;


@RestController
public class Matcontroller {
    @Autowired
    Matrepository matrepository;
    @RequestMapping("/findAll")
    public String findAll(@RequestParam("uid") String uid){
        List<Matentity> matentities=matrepository.findAllByUid(uid);
        Matentitylist matentitylist=new Matentitylist(matentities);
        return matentitylist.toJson();
    }
    @RequestMapping("/deleteById")
    public void deleteById(@RequestParam("id") String id){
        matrepository.deleteById(id);
    }
    @RequestMapping("/save")
    public void save(@RequestParam("matentity") String matentity){
        try {
            String decodedString = URLDecoder.decode(matentity, "UTF-8");
            Gson gson = new Gson();
            Matentity mat = gson.fromJson(decodedString, Matentity.class);
            matrepository.save(mat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/findByCid")
    public String findByCid(@RequestParam("cid") String cid){
        Optional<Matentity> mat = matrepository.findById(cid);
        return mat.get().toJson();
    }
    @RequestMapping("/update")
    public void update(@RequestParam("id") String id, @RequestParam("matentity") String matentity) throws UnsupportedEncodingException {
        try {
            String decodedString = URLDecoder.decode(matentity, "UTF-8");
            Gson gson = new Gson();
            Matentity mat = gson.fromJson(decodedString, Matentity.class);
            matrepository.deleteById(mat.getId());
            matrepository.save(mat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/addFile")
    public void addFile(@RequestParam("file") String file){
        try {
            String dfile = URLDecoder.decode(file, "UTF-8");
            System.out.println(dfile);
            Gson gson = new Gson();
            Matentity[] matentities = gson.fromJson(dfile, Matentity[].class);
            for (Matentity matentity : matentities) {
                matrepository.save(matentity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

