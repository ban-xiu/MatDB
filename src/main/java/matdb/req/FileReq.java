package matdb.req;

import matdb.entity.MatEntity;

import java.util.Arrays;

public class FileReq {
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
