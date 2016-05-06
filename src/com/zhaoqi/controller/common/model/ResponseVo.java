package com.zhaoqi.controller.common.model;

/**
 * Created by zhaoqi on 2016/5/5.
 */
public class ResponseVo {
    private String msg;
    private Integer code = 13000;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
