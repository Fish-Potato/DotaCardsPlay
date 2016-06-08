package com.zhaoqi.component.webservice;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhaoqi on 2016/5/12.
 */
public class Invoker implements ServiceCaller{
    private ServiceFinder serviceFinder;
    @Override
    public <T> T execute(String serviceName, String param, Class<T> clazz) throws ServiceNotFoundException {
        ServiceInstanceDetail serviceInstanceDetail = this.serviceFinder.getService(serviceName);
        // call
        return  this.doGet(serviceInstanceDetail,param,clazz);
    }

    private <T> T doGet(ServiceInstanceDetail detail, String param, Class<T> clazz) {
        String url = detail.getLocalIp()+detail.getLocalPort();
        return DotaHttpClient.send(param,url, RequestMethod.GET,clazz,0,0);
    }
}
