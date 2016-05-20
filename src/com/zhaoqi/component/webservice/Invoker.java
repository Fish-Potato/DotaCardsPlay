package com.zhaoqi.component.webservice;

import com.zhaoqi.component.webservice.hystrix.HystrixCommonCommand;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by zhaoqi on 2016/5/12.
 */
@SuppressWarnings("unchecked")
public class Invoker implements ServiceCaller{
    private ServiceFinder serviceFinder;
    @Override
    public <T> T execute(String serviceName, String param, Class<T> clazz, T fallBack) throws ServiceNotFoundException, InterruptedException, ExecutionException, TimeoutException {
        HystrixCommonCommand commonCommand = new HystrixCommonCommand(serviceName,serviceFinder, RequestMethod.GET,param,clazz);
        commonCommand.setFallBack(fallBack);
        Future future = commonCommand.queue();
        return (T)future.get(1, TimeUnit.SECONDS);
    }

    @Override
    public <T> Future<T> futureGet(String serviceName, String param, Class<T> clazz, T fallBack) throws Exception {
        HystrixCommonCommand commonCommand = new HystrixCommonCommand(serviceName,serviceFinder, RequestMethod.GET,param,clazz);
        commonCommand.setFallBack(fallBack);
        Future future = commonCommand.queue();
        return future;
    }

    @Override
    public <T> Future<T> futureGet(String serviceName, String param, Class<T> clazz) throws Exception {
        return this.futureGet(serviceName, param, clazz,null);
    }
}
