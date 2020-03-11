package com.study.jpajdbctemplate.util;

import lombok.Data;

/**
 * @author jinzl
 * @title: Result
 * @Package com.jinzl.demo.config
 * @ProjectName: springboot_demo0221
 * @date 2020/2/26
 */

@Data
public class Result<T> {

    private int code=200;
    private Exception e;
    private String msg;
    private T data;

    public Result(String msg, int code,Exception e) {
        this.msg = msg;
        this.code = code;
        this.e = e;
    }

    public Result(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public Result(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public Result(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public Result(String msg) {
        this.msg = msg;
        this.code = 200;
    }

    public Result(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(message);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> success(String message,T data) {
        return new Result<>(message,data);
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(message, code);
    }
}
