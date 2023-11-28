package com.matdb.controller;

import com.matdb.domain.dto.DBInfoDto;
import com.matdb.domain.dto.DBCardDto;
import com.matdb.domain.vo.req.ChangeDBCardReq;
import com.matdb.domain.vo.req.TemplateReq;
import com.matdb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DBController {

    @Autowired
    DBService dbService;

    @PostMapping("/templateSave")
    public void templateSave(@RequestBody TemplateReq templateReq){
        System.out.println("\ntemplateSave:" + templateReq.toString());
        dbService.templateSave(templateReq);
    }
    @GetMapping("/findDBInof")
    public List<DBInfoDto> findDBInof(@RequestParam("username") String username){
        System.out.println("\nfindDBInof:" + username);
        List<DBInfoDto> infos = dbService.findDBInof(username);
        System.out.println("\nfindDBInof:" + infos.toString());
        return infos;
    }
    @GetMapping("/findDBCard")
    public DBCardDto findDBCard(@RequestParam("id") String id){
        System.out.println("\nfindDBCard:" + id);
        DBCardDto card = dbService.findDBCard(id);
        System.out.println("\nfindDBCard:" + card.toString());
        return card;
    }
    @PostMapping("/changeDBCard")
    public void changDBCard(@RequestBody ChangeDBCardReq changeDBCardReq){
        System.out.println("\nchangeDBCard:" + changeDBCardReq.toString());
        dbService.changDBCard(changeDBCardReq);
    }
    @DeleteMapping("/destroy")
    public void destroy(@RequestParam("uid") String id){
        System.out.println("\ndestroy:" + id);
        dbService.destroy(id);
    }

}
