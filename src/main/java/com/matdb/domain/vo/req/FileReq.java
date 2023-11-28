package com.matdb.domain.vo.req;

import com.matdb.domain.entity.MatEntity;

import java.io.Serializable;
import java.util.Arrays;

public class FileReq implements Serializable {
    private MatEntity[] matEntities;

    public FileReq(){}
    public FileReq(MatEntity[] matEntities) {
        this.matEntities = matEntities;
    }

    public MatEntity[] getMatEntities() {
        return matEntities;
    }

    public void setMatEntities(MatEntity[] matEntities) {
        this.matEntities = matEntities;
    }

    @Override
    public String toString() {
        return "FileReq{" +
                "matEntities=" + Arrays.toString(matEntities) +
                '}';
    }
}
