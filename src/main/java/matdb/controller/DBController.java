package matdb.controller;

import matdb.entity.DBEntity;
import matdb.vo.req.ChangeDBCardReq;
import matdb.vo.req.TemplateReq;
import matdb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DBController {

    @Autowired
    DBService dbService;

    @PostMapping("/templateSave")
    public void templateSave(@RequestBody TemplateReq templateReq){
        System.out.println("templateSave:" + templateReq.toString());
        dbService.templateSave(templateReq);
    }
    @GetMapping("/findDBInof")
    public List<DBEntity> findDBInof(@RequestParam("username") String username){
        System.out.println("findDBInof:" + username);
        List<DBEntity> dbs = dbService.findDBInof(username);
        return dbs;
    }
    @GetMapping("/findDBCard")
    public DBEntity findDBCard(@RequestParam("id") String id){
        System.out.println("findDBCard:" + id);
        DBEntity card = dbService.findDBCard(id);
        System.out.println("findDBCard:" + card);
        return card;
    }
    @PostMapping("/changeDBCard")
    public void changDBCard(@RequestBody ChangeDBCardReq changeDBCardReq){
        System.out.println("changeDBCard:" + changeDBCardReq.toString());
        dbService.changDBCard(changeDBCardReq);
    }
    @DeleteMapping("/destroy")
    public void destroy(@RequestParam("uid") String id){
        System.out.println("destroy:" + id);
        dbService.destroy(id);
    }

}
