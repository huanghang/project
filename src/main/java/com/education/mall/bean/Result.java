package com.education.mall.bean;


import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = -6785697045225216075L;
    private Integer code;
    private String message;
    private Object data;


    public String getMessage() {
        return message;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public static Result success(String message) {
        return new Result().code(200).message(message);
    }

    public static Result success(String message, Object data) {
        return new Result().code(200).message(message).data(data);
    }

    public static Result success(Object data) {
        return new Result().code(200).data(data);
    }


    public static Result error(String message) {
        return new Result().code(500).message(message);
    }

    public static Result error(String message, Object data) {
        return new Result().code(500).message(message).data(data);
    }

    public static Result error(Object data) {
        return new Result().code(500).data(data);
    }


    public static Result noPermission(String message) {
        return new Result().code(403).message(message);
    }

    public static Result noPermission(String message, Object data) {
        return new Result().code(403).message(message).data(data);
    }

    public static Result noPermission(Object data) {
        return new Result().code(403).data(data);
    }

    public static Result loginTimeout(String message) {
        return new Result().code(401).message(message);
    }

    public static Result loginTimeout(String message, Object data) {
        return new Result().code(401).message(message).data(data);
    }

    public static Result loginTimeout(Object data) {
        return new Result().code(401).data(data);
    }

    public Object getData() {
        return data;
    }

    public Result data(Object data) {
        this.data = data;
        return this;
    }

    public boolean isOk() {
        return getCode() != null && 200 == getCode();
    }

    public Integer getCode() {
        return code;
    }

    public Result code(Integer code) {
        this.code = code;
        return this;
    }
}
