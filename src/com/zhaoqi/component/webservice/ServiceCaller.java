package com.zhaoqi.component.webservice;

/**
 * Created by zhaoqi on 2016/5/12.
 */
public interface ServiceCaller {
    <T> DotaFuture<T> futureGet(String serviceName, Object param, Class<T> clazz, T fallBack) throws  Exception;
    <T> DotaFuture<T> futureGet(String serviceName, Object param, Class<T> clazz) throws  Exception;
    <T> DotaFuture<T> futureGet(String serviceName, Object param, Class<T> clazz,int timeOut) throws  Exception;
    <T> DotaFuture<T> futureGet(String serviceName, Object param, Class<T> clazz,T fallBack,int timeOut) throws  Exception;
    <T> DotaFuture<T> futurePost(String serviceName,Object param, Class<T> clazz) throws Exception;
    <T> DotaFuture<T> futurePost(String serviceName,Object param, Class<T> clazz, T fallBack) throws Exception;
    <T> DotaFuture<T> futurePost(String serviceName, Object param, Class<T> clazz,int timeOut) throws  Exception;
    <T> DotaFuture<T> futurePost(String serviceName, Object param, Class<T> clazz,T fallBack,int timeOut) throws  Exception;
}
