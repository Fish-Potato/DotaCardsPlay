package com.zhaoqi.component.webservice;

import java.util.concurrent.Future;

/**
 * Created by zhaoqi on 2016/5/12.
 */
public interface ServiceCaller {
    <T> T execute(String serviceName, Object param, Class<T> clazz, T fallBack) throws Exception;
    <T> Future<T> futureGet(String serviceName, Object param, Class<T> clazz, T fallBack) throws  Exception;
    <T> Future<T> futureGet(String serviceName, Object param, Class<T> clazz) throws  Exception;
}
