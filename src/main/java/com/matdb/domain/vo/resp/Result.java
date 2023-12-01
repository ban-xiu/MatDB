package com.matdb.domain.vo.resp;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    private final static String successMsg = "Success.";
    private final static String errorMsg = "Error.";

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.msg = successMsg;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.msg = successMsg;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result<T>();
        result.msg = errorMsg;
        result.code = 0;
        return result;
    }

    public static <T> Result<T> error(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.msg = errorMsg;
        result.code = 0;
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
