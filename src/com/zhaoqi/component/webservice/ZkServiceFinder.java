package com.zhaoqi.component.webservice;


import java.util.List;

import org.apache.curator.x.discovery.ServiceInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaoqi on 2016/5/13.
 */
public class ZkServiceFinder implements ServiceFinder {

    private final Logger logger = LoggerFactory.getLogger(ZkServiceFinder.class);

    private ZkCuratorServiceClient client;

    private Strategy strategy;

    public ZkServiceFinder() {
    }

    @Override
    public ServiceInstanceDetail getService(String serviceName) throws ServiceNotFoundException{
        try {
            List instances =this.client.getServiceByName(serviceName);
            ServiceInstance serviceInstance = (ServiceInstance) this.strategy.getServiceInstance(instances);
            return (ServiceInstanceDetail)serviceInstance.getPayload();
        } catch (Exception e) {
            logger.error("get service {} failed {}",serviceName,e);
            throw new ServiceNotFoundException(serviceName);
        }
    }

    public void setClient(ZkCuratorServiceClient client) {
        this.client = client;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
