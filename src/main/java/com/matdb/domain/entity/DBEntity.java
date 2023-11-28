package com.matdb.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;

@Document(collection = "matTemplates")
public class DBEntity {
    @Id
    private String id;
    @Field("title")
    private String title;
    @Field("introduction")
    private String introduction;
    @Field("type")
    private String type;
    @Field("username")
    private String username;
    @Field("speciality")
    private String[] speciality;

    @Field("specialityType")
    private String[] specialityType;
    @Field("img")
    private byte[] img;
    public DBEntity(){};

    public DBEntity(String id, String title, String introduction, String type, String username, String[] speciality, String[] specialityType, byte[] img) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.type = type;
        this.username = username;
        this.speciality = speciality;
        this.specialityType = specialityType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String[] speciality) {
        this.speciality = speciality;
    }

    public String[] getSpecialityType() {
        return specialityType;
    }

    public void setSpecialityType(String[] specialityType) {
        this.specialityType = specialityType;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Override
    public String toString() {
        byte[] arr;
        if (img != null) {
            arr = Arrays.copyOfRange(img,0,5);
        } else {
            arr = null;
        }
        return "DBEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", speciality=" + Arrays.toString(speciality) +
                ", specialityType=" + Arrays.toString(specialityType) +
                ", img=" + Arrays.toString(arr) +
                '}';
    }
}
