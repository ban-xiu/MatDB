package matdb.req;

import matdb.entity.DBEntity;

public class TemplateReq {
    private DBEntity dbEntity;
    public TemplateReq(){}

    public TemplateReq(DBEntity dbEntity) {
        this.dbEntity = dbEntity;
    }

    public DBEntity getDbEntity() {
        return dbEntity;
    }

    public void setDbEntity(DBEntity dbEntity) {
        this.dbEntity = dbEntity;
    }

    @Override
    public String toString() {
        return "TemplateReq{" +
                "dbEntity=" + dbEntity +
                '}';
    }
}
