package matdb.entity;

import com.google.gson.Gson;

import java.util.List;


public class Matentitylist {

    private List<Matentity> matentityList;
    public Matentitylist(){};
    public Matentitylist(List<Matentity> matentityList){
        this.matentityList=matentityList;
    }
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    public List<Matentity> getMatentityList() {
        return matentityList;
    }

    public void setMatentityList(List<Matentity> matentityList) {
        this.matentityList = matentityList;
    }
}
