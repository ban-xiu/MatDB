package com.matdb.domain.dto;

import java.io.Serializable;
import java.util.Arrays;

public class DBInfoDTO implements Serializable {
    private String id;

    private String title;

    private String introduction;

    private String type;

    private String username;

    private byte[] img;

    public DBInfoDTO(){}

    public DBInfoDTO(String id, String title, String introduction, String type, String username, byte[] img) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.type = type;
        this.username = username;
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
        return "DBInfoDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", img=" + Arrays.toString(arr) +
                '}';
    }

}
