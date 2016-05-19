package com.zhaoqi.component.webservice;

/**
 * Created by zhaoqi on 2016/5/12.
 */
public class Invoker implements ServiceCaller{
    private ServiceFinder serviceFinder;
    @Override
    public <T> T execute(String serviceName, String param, Class<T> clazz) throws ServiceNotFoundException {
        ServiceInstanceDetail serviceInstanceDetail = this.serviceFinder.getService(serviceName);
        // call
        return null;
    }
}
