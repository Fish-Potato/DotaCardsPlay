package com.zhaoqi.controller.test.redis.model;

import com.zhaoqi.restapi.HelloRequest;

import java.util.List;

/**
 * Created by zhaoqi on 2016/8/15 0015.
 */
public class RedisTestRequest {
    private String a;

    private int b;

    private List<String> c;

    private HelloRequest helloRequest;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public List<String> getC() {
        return c;
    }

    public void setC(List<String> c) {
        this.c = c;
    }

    public HelloRequest getHelloRequest() {
        return helloRequest;
    }

    public void setHelloRequest(HelloRequest helloRequest) {
        this.helloRequest = helloRequest;
    }
}
