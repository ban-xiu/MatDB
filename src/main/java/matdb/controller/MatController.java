package matdb.controller;

import matdb.dto.MatDto;
import matdb.req.FileReq;
import matdb.req.SaveReq;
import matdb.req.UpdateReq;
import matdb.service.MatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MatController {
    @Autowired
    MatService matService;
    @GetMapping("/findAll")
    public List<MatDto> findAll(@RequestParam String uid){
        System.out.println("findAll:" + uid);
        List<MatDto> mats = matService.findAll(uid);
        return mats;
    }
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam("id") String id){
        System.out.println("deleteById:" + id);
        matService.deleteById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody SaveReq saveReq){
        System.out.println("save:" + saveReq.toString());
        matService.save(saveReq);
    }
    @GetMapping("/findByCid")
    public MatDto findByCid(@RequestParam("cid") String cid){
        System.out.println("findByCid:" + cid);
        MatDto mat = matService.findByCid(cid);
        System.out.println(mat);
        return mat;
    }
    @PutMapping("/update")
    public void update(@RequestBody UpdateReq updateReq) {
        System.out.println("update:" + updateReq.toString());
        matService.update(updateReq);
    }
    @PostMapping("/addFile")
    public void addFile(@RequestBody FileReq file){
        System.out.println(file);
        System.out.println("file:");
        matService.addFile(file);
    }
}

