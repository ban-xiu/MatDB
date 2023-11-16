package matdb.controller;

import matdb.dto.DBCardDto;
import matdb.dto.DBInfoDto;
import matdb.req.ChangeDBCardReq;
import matdb.req.TemplateReq;
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
    public List<DBInfoDto> findDBInof(@RequestParam("username") String username){
        System.out.println("findDBInof:" + username);
        List<DBInfoDto> infos = dbService.findDBInof(username);
        return infos;
    }
    @GetMapping("/findDBCard")
    public DBCardDto findDBCard(@RequestParam("id") String id){
        System.out.println("findDBCard:" + id);
        DBCardDto card = dbService.findDBCard(id);
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
