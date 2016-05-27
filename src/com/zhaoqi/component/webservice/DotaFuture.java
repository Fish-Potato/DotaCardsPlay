package com.zhaoqi.component.webservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaoqi on 2016/5/27.
 */
public class DotaFuture<T> {

    private static final Logger logger = LoggerFactory.getLogger(DotaFuture.class);

    private Future<T> future;
    private int waitingTime;
    private String serviceName;

    public DotaFuture(Future<T> future,String serviceName,int waitingTime) {
        this.future = future;
        this.waitingTime = waitingTime;
        this.serviceName = serviceName;
    }

    public T get() throws InterruptedException, ExecutionException, TimeoutException {
        return this.get(waitingTime);
    }

    public T get(int timeOut) throws InterruptedException, ExecutionException, TimeoutException {
        T t =future.get(timeOut, TimeUnit.SECONDS);
        logger.info("call service [{}] success return [{}]",serviceName,t);
        return t;
    }
}
