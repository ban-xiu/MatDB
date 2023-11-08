package matdb.vo.req;

import matdb.entity.MatEntity;

public class UpdateReq {
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
