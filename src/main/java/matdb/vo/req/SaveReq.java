package matdb.vo.req;

import matdb.entity.MatEntity;

public class SaveReq {
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
