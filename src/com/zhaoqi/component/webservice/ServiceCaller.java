package com.zhaoqi.component.webservice;

/**
 * Created by zhaoqi on 2016/5/12.
 */
public interface ServiceCaller {
    <T> T execute(String serviceName, String param, Class<T> clazz);
}
