package matdb.controller;

import matdb.entity.DBentity;
import matdb.req.ChangeDBCrad;
import matdb.req.TemplateReq;
import matdb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DBcontroller {

    @Autowired
    DBService dbService;

    @PostMapping("/templateSave")
    public void templateSave(@RequestBody TemplateReq templateReq){
        System.out.println("templateSave:" + templateReq.toString());
        dbService.templateSave(templateReq);
    }
    @GetMapping("/findDBInof")
    public List<DBentity> findDBInof(@RequestParam("username") String username){
        System.out.println("findDBInof:" + username);
        List<DBentity> dbentities = dbService.findDBInof(username);
        return dbentities;
    }
    @GetMapping("/findDBCard")
    public DBentity findDBCard(@RequestParam("id") String id){
        System.out.println("findDBCard:" + id);
        DBentity card = dbService.findDBCard(id);
        System.out.println("findDBCard:" + card);
        return card;
    }
    @PostMapping("/changeDBCard")
    public void changDBCard(@RequestBody ChangeDBCrad changeDBCrad){
        System.out.println("changeDBCard:" + changeDBCrad.toString());
        dbService.changDBCard(changeDBCrad);
    }
    @DeleteMapping("/destroy")
    public void destroy(@RequestParam("uid") String uid){
        System.out.println("destroy:" + uid);
        dbService.destroy(uid);
    }

}
