package com.zhaoqi.component.webservice;

/**
 * Created by zhaoqi on 2016/5/19.
 */
public class ServiceNotFoundException extends Exception {

    private String message;

    private String serviceName;

    public ServiceNotFoundException(String serviceName) {
        super();
        this.serviceName = serviceName;
    }

    public String getMessage() {
        return "Could find service : " + serviceName;
    }

}
