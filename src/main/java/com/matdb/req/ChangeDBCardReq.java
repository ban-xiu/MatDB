package com.matdb.req;


import java.util.Arrays;

public class ChangeDBCardReq {
   private String id;
   private String title;
   private String introduction;

   private byte[] img;
   public ChangeDBCardReq(){}

   public ChangeDBCardReq(String id, String title, String introduction, byte[] img) {
      this.id = id;
      this.title = title;
      this.introduction = introduction;
      this.img = img;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getIntroduction() {
      return introduction;
   }

   public void setIntroduction(String introduction) {
      this.introduction = introduction;
   }

   public byte[] getImg() {
      return img;
   }

   public void setImg(byte[] img) {
      this.img = img;
   }

   @Override
   public String toString() {
      byte[] arr = Arrays.copyOfRange(img,0,5);
      return "ChangeDBCardReq{" +
              "id='" + id + '\'' +
              ", title='" + title + '\'' +
              ", introduction='" + introduction + '\'' +
              ", img=" + Arrays.toString(arr) +
              '}';
   }
}
