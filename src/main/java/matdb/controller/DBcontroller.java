package matdb.controller;


import matdb.entity.DBentity;
import matdb.entity.DBentitylist;
import matdb.repository.DBrepository;
import matdb.repository.Matrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;


@RestController
public class DBcontroller {
    @Autowired
    DBrepository dbrepository;
    @Autowired
    Matrepository matrepository;
    @RequestMapping("/templateSave")
    public void templateSave(@RequestParam("title") String title,@RequestParam("introduction") String introduction,@RequestParam("type") String type,@RequestParam("username") String username ,@RequestParam("speciality") String speciality){
        try {
            String dtitle = URLDecoder.decode(title, "UTF-8");
            String dintroduction=URLDecoder.decode(introduction, "UTF-8");
            String dtype=URLDecoder.decode(type, "UTF-8");
            String dusername=URLDecoder.decode(username, "UTF-8");
            String dspeciality=URLDecoder.decode(speciality, "UTF-8");
            String[] specialityArray = dspeciality.split(",");
            DBentity db=new DBentity(null,dtitle,dintroduction,dtype,dusername,specialityArray);
            dbrepository.save(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/findDBInof")
    public String findDBInof(@RequestParam("username") String username){
        try {
            String dusername=URLDecoder.decode(username, "UTF-8");
            List<DBentity> dbentities=dbrepository.findAllByUsername(dusername);
            DBentitylist dbentitylist = new DBentitylist(dbentities);
            return dbentitylist.toJson();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    @RequestMapping("/findDBCard")
    public String findDBCard(@RequestParam("id") String id){
        Optional<DBentity> dbentity=dbrepository.findById(id);
        return dbentity.get().toJson();
    }
    @RequestMapping("/changeDBCard")
    public void changDBCard(@RequestParam("id") String id ,@RequestParam("title") String title,@RequestParam("introduction") String introduction){
        try {
            String dtitle = URLDecoder.decode(title, "UTF-8");
            String dintroduction=URLDecoder.decode(introduction, "UTF-8");
            Optional<DBentity> dbentity=dbrepository.findById(id);
            DBentity db= dbentity.get();
            db.setTitle(dtitle);
            db.setIntroduction(dintroduction);
            dbrepository.deleteById(id);
            dbrepository.save(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/destroy")
    public void destroy(@RequestParam("uid") String uid){
        try {
            matrepository.deleteByUid(uid);
            dbrepository.deleteById(uid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
