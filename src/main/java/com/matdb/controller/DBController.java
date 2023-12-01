package com.matdb.controller;

import com.matdb.domain.dto.DBInfoDto;
import com.matdb.domain.dto.DBCardDto;
import com.matdb.domain.vo.req.ChangeDBCardReq;
import com.matdb.domain.vo.req.TemplateReq;
import com.matdb.domain.vo.resp.Result;
import com.matdb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DBController {

    @Autowired
    DBService dbService;

    @PostMapping("/templateSave")
    public Result<String> templateSave(@RequestBody TemplateReq templateReq){
        System.out.println("\ntemplateSave:" + templateReq.toString());
        return dbService.templateSave(templateReq);
    }

    @GetMapping("/findDBInof")
    public Result<List<DBInfoDto>> findDBInof(){
        List<DBInfoDto> infos = dbService.findDBInof();
        System.out.println("\nfindDBInof:" + infos.toString());
        return Result.success(infos);
    }
    @GetMapping("/findDBCard")
    public Result<DBCardDto> findDBCard(@RequestParam("id") String id){
        System.out.println("\nfindDBCard:" + id);
        DBCardDto card = dbService.findDBCard(id);
        System.out.println("\nfindDBCard:" + card.toString());
        return Result.success(card);
    }
    @PostMapping("/changeDBCard")
    public Result<String> changDBCard(@RequestBody ChangeDBCardReq changeDBCardReq){
        System.out.println("\nchangeDBCard:" + changeDBCardReq.toString());
        return dbService.changDBCard(changeDBCardReq);
    }
    @DeleteMapping("/destroy")
    public Result<String> destroy(@RequestParam("uid") String id){
        System.out.println("\ndestroy:" + id);
        return dbService.destroy(id);
    }

}
