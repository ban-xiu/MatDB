package com.matdb.domain.dto;

import java.io.Serializable;
import java.util.Arrays;

public class DBCardDto implements Serializable {
    private String id;

    private String title;

    private String introduction;

    private String type;

    private String username;

    private String[] speciality;

    private String[] specialityType;

    private byte[] img;

    public DBCardDto(){}

    public DBCardDto(String id, String title, String introduction, String type, String username, String[] speciality, String[] specialityType, byte[] img) {
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
        return "DBCardDto{" +
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
