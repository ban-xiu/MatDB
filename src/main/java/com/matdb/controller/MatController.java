package com.matdb.controller;

import com.matdb.domain.dto.MatDto;
import com.matdb.domain.vo.req.FileReq;
import com.matdb.domain.vo.req.SaveReq;
import com.matdb.domain.vo.req.UpdateReq;
import com.matdb.domain.vo.resp.Result;
import com.matdb.service.MatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MatController {
    @Autowired
    MatService matService;
    @GetMapping("/findAll")
    public Result<List<MatDto>> findAll(@RequestParam String uid){
        System.out.println("\nfindAll:" + uid);
        List<MatDto> mats = matService.findAll(uid);
        System.out.println("\nfindAll:" + mats.toString());
        return Result.success(mats);
    }
    @DeleteMapping("/deleteById")
    public Result<String> deleteById(@RequestParam("id") String id){
        System.out.println("\ndeleteById:" + id);
        return matService.deleteById(id);
    }
    @PostMapping("/save")
    public Result<String> save(@RequestBody SaveReq saveReq){
        System.out.println("\nsave:" + saveReq.toString());
        return matService.save(saveReq);
    }
    @GetMapping("/findByCid")
    public Result<MatDto> findByCid(@RequestParam("cid") String cid){
        System.out.println("\nfindByCid:" + cid);
        MatDto mat = matService.findByCid(cid);
        System.out.println("\nfindByCid:" + mat.toString());
        return Result.success(mat);
    }
    @PutMapping("/update")
    public Result<String> update(@RequestBody UpdateReq updateReq) {
        System.out.println("\nupdate:" + updateReq.toString());
        return matService.update(updateReq);
    }
    @PostMapping("/addFile")
    public Result<String> addFile(@RequestBody FileReq file){
        System.out.println("\nfile:" + file.toString());
        return matService.addFile(file);
    }
}

