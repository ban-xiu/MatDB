package com.matdb.domain.vo.req;

import com.matdb.domain.entity.MatEntity;

import java.io.Serializable;

public class UpdateReq implements Serializable {
    private String id;
    private MatEntity matEntity;
    public UpdateReq(){}

    public UpdateReq(String id, MatEntity matEntity) {
        this.id = id;
        this.matEntity = matEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MatEntity getMatEntity() {
        return matEntity;
    }

    public void setMatEntity(MatEntity matentity) {
        this.matEntity = matentity;
    }

    @Override
    public String toString() {
        return "UpdateReq{" +
                "id='" + id + '\'' +
                ", matEntity=" + matEntity +
                '}';
    }
}
