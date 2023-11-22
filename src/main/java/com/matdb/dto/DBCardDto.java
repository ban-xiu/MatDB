package com.matdb.dto;

import java.util.Arrays;

public class DBCardDto {
    private String id;

    private String title;

    private String introduction;

    private String type;

    private String[] speciality;

    private String[] specialityType;

    private byte[] img;

    public DBCardDto(){}

    public DBCardDto(String id, String title, String introduction, String type, String[] speciality, String[] specialityType, byte[] img) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.type = type;
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
        byte[] arr = Arrays.copyOfRange(img,0,5);
        return "DBCardDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                ", speciality=" + Arrays.toString(speciality) +
                ", specialityType=" + Arrays.toString(specialityType) +
                ", img=" + Arrays.toString(arr) +
                '}';
    }
}
