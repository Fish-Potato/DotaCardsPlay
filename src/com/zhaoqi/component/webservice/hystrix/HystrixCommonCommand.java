package com.zhaoqi.component.webservice.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.zhaoqi.component.webservice.DotaHttpClient;
import com.zhaoqi.component.webservice.ServiceFinder;
import com.zhaoqi.component.webservice.ServiceInstanceDetail;

/**
 * Created by zhaoqi on 2016/5/20.
 */
public class HystrixCommonCommand<T> extends HystrixCommand<T> {

    private static final Logger logger = LoggerFactory.getLogger(HystrixCommonCommand.class);

    private String serviceName;
    private ServiceFinder serviceFinder;
    private RequestMethod methodType;
    private Object param;
    private Class responseType;
    private T fallBack;

    public HystrixCommonCommand(String serviceName, ServiceFinder serviceFinder, RequestMethod methodType, Object param, Class<T> responseType, int timeOut) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(serviceName.split("\\.")[0]))
                .andCommandKey(HystrixCommandKey.Factory.asKey(serviceName))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(timeOut)));
        this.serviceName=serviceName;
        this.serviceFinder=serviceFinder;
        this.methodType=methodType;
        this.param=param;
        this.responseType=responseType;
    }

    /**
     * 重写run方法，实现熔断器保护下的接口调用
     * @return
     * @throws Exception
     */
    @Override
    protected T run() throws Exception {
        // http call
        ServiceInstanceDetail detail = serviceFinder.getService(serviceName);
        return this.doHttpCall(detail);
    }

    @SuppressWarnings("unchecked")
    private T doHttpCall(ServiceInstanceDetail detail) {
        String url = "http://"+detail.getLocalIp()+":"+detail.getLocalPort()+detail.getClassPath()+detail.getMethodPath();
        return (T) DotaHttpClient.send(param,url, methodType,responseType,0,0);
    }

    public void setFallBack(T fallBack) {
        this.fallBack = fallBack;
    }

    /**
     * 降级，接口调用失败会执行fallback
     * @return
     */
    protected T getFallback() {
        logger.info("execute service [{}] failed ,do fallback",serviceName);
        if (null != fallBack) {
            // 执行fallback
            fallBack = doFallBack();
            return fallBack;
        }
        else {
            throw new UnsupportedOperationException("No fallback available."+serviceName);
        }
    }

    private T doFallBack() {
        // do something
        return null;
    }
}
