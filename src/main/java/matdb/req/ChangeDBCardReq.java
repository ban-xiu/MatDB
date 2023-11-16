package matdb.req;

import matdb.entity.DBEntity;

public class ChangeDBCardReq {
   private DBEntity dbEntity;
   public ChangeDBCardReq(){}

   public ChangeDBCardReq(DBEntity dbEntity) {
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
      return "ChangeDBCardReq{" +
              "dbEntity=" + dbEntity +
              '}';
   }
}
