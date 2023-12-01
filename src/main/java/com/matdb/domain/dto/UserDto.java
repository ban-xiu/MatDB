package com.matdb.domain.dto;

import org.springframework.data.mongodb.core.mapping.Field;

public class UserDto {

    private String username;
    private String password;
    private String key;

    private String msg;

    public UserDto(){}

    public UserDto(String username, String password, String key, String msg) {
        this.username = username;
        this.password = password;
        this.key = key;
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
