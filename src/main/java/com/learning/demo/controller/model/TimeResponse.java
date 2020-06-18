package com.learning.demo.controller.model;

/**
 * @program: demo1
 * @description:
 * @author: Tan.jie
 * @create: 2020-06-18 12:40
 **/
public class TimeResponse {
    private String data;
    private int code;

    public void setData(String data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public int getCode() {
        return code;
    }
}
