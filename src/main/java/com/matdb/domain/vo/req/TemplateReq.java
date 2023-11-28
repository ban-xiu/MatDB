package com.matdb.domain.vo.req;

import com.matdb.domain.entity.DBEntity;

import java.io.Serializable;

public class TemplateReq implements Serializable {
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
