package com.matdb.domain.vo.req;

import com.matdb.domain.entity.MatEntity;

import java.io.Serializable;

public class SaveReq implements Serializable {
    private MatEntity matEntity;
    public SaveReq(){}

    public SaveReq(MatEntity matEntity) {
        this.matEntity = matEntity;
    }

    public MatEntity getMatEntity() {
        return matEntity;
    }

    public void setMatEntity(MatEntity matEntity) {
        this.matEntity = matEntity;
    }

    @Override
    public String toString() {
        return "SaveReq{" +
                "matEntity=" + matEntity +
                '}';
    }
}
