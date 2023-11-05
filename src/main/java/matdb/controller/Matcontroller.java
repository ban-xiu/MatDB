package matdb.controller;

import matdb.entity.Matentity;
import matdb.req.UpdateReq;
import matdb.service.MatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Matcontroller {
    @Autowired
    MatService matService;
    @GetMapping("/findAll")
    public List<Matentity> findAll(@RequestParam String uid){
        System.out.println("findAll" + uid);
        List<Matentity> matentities = matService.findAll(uid);
        return matentities;
    }
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam("id") String id){
        System.out.println("deleteById:" + id);
        matService.deleteById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Matentity matentity){
        System.out.println("save" + matentity.toString());
        matService.save(matentity);
    }
    @GetMapping("/findByCid")
    public String findByCid(@RequestParam("cid") String cid){
        System.out.println("findByCid:" + cid);
        String mat = matService.findByCid(cid);
        System.out.println(mat);
        return mat;
    }
    @PutMapping("/update")
    public void update(@RequestBody UpdateReq updateReq) {
        System.out.println("update:" + updateReq.toString());
        matService.update(updateReq);
    }
    @PostMapping("/addFile")
    public void addFile(@RequestBody Matentity[] file){
        System.out.println("file");
        matService.addFile(file);
    }
}

