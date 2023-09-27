package matdb.entity;

import com.google.gson.Gson;

import java.util.List;

public class DBentitylist {
    private List<DBentity> dbentityList;

    public DBentitylist(){};
    public DBentitylist(List<DBentity> dbentityList) {
        this.dbentityList = dbentityList;
    }
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public List<DBentity> getdbentityList() {
        return dbentityList;
    }

    public void setdbentityList(List<DBentity> dbentityList) {
        this.dbentityList = dbentityList;
    }
}
