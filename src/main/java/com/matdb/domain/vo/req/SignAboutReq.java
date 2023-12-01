package com.matdb.domain.vo.req;

import java.io.Serializable;

public class SignAboutReq implements Serializable {
    private String username;
    private String password;
    private String key;

    public SignAboutReq(){}

    public SignAboutReq(String username, String password, String key) {
        this.username = username;
        this.password = password;
        this.key = key;
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

    @Override
    public String toString() {
        return "SignAboutReq{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
