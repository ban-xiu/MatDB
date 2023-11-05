package matdb.req;

import matdb.entity.Matentity;

public class UpdateReq {
    private String id;
    private Matentity matentity;
    public UpdateReq(){}

    public UpdateReq(String id, Matentity matentity) {
        this.id = id;
        this.matentity = matentity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Matentity getMatentity() {
        return matentity;
    }

    public void setMatentity(Matentity matentity) {
        this.matentity = matentity;
    }

    @Override
    public String toString() {
        return "UpdateReq{" +
                "id='" + id + '\'' +
                ", matentity=" + matentity +
                '}';
    }
}
