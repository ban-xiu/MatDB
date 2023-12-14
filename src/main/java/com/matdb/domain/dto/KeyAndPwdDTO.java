package com.matdb.domain.dto;

import java.io.Serializable;

public class KeyAndPwdDTO implements Serializable {
    private String key;
    private String password;

    public KeyAndPwdDTO(){}

    public KeyAndPwdDTO(String key, String password) {
        this.key = key;
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "KeyAndPwdDTO{" +
                "key='" + key + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
