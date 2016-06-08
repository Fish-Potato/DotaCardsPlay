package com.zhaoqi.component.webservice;

/**
 * Created by zhaoqi on 2016/5/17.
 */
public interface IRegister {
    void registerService(String hostName,String ip,String port,String classPath, String methodPath,String serviceName,String serviceGroup);
}
