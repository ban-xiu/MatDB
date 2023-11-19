package com.matdb.controller;

import com.matdb.dto.MatDto;
import com.matdb.req.FileReq;
import com.matdb.req.SaveReq;
import com.matdb.req.UpdateReq;
import com.matdb.service.MatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MatController {
    @Autowired
    MatService matService;
    @GetMapping("/findAll")
    public List<MatDto> findAll(@RequestParam String uid){
        System.out.println("\nfindAll:" + uid);
        List<MatDto> mats = matService.findAll(uid);
        System.out.println("\nfindAll:" + mats.toString());
        return mats;
    }
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam("id") String id){
        System.out.println("\ndeleteById:" + id);
        matService.deleteById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody SaveReq saveReq){
        System.out.println("\nsave:" + saveReq.toString());
        matService.save(saveReq);
    }
    @GetMapping("/findByCid")
    public MatDto findByCid(@RequestParam("cid") String cid){
        System.out.println("\nfindByCid:" + cid);
        MatDto mat = matService.findByCid(cid);
        System.out.println("\nfindByCid:" + mat.toString());
        return mat;
    }
    @PutMapping("/update")
    public void update(@RequestBody UpdateReq updateReq) {
        System.out.println("\nupdate:" + updateReq.toString());
        matService.update(updateReq);
    }
    @PostMapping("/addFile")
    public void addFile(@RequestBody FileReq file){
        System.out.println("\nfile:" + file.toString());
        matService.addFile(file);
    }
}

