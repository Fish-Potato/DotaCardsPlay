package com.zhaoqi.component.webservice;

/**
 * Created by zhaoqi on 2016/5/13.
 */
public interface ServiceFinder {
//    <T> T getServiceFinder();

    ServiceInstanceDetail getService(String serviceName) throws ServiceNotFoundException;
}
