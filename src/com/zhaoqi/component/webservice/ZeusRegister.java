package com.zhaoqi.component.webservice;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaoqi on 2016/5/17.
 */
public class ZeusRegister implements IRegister{

    private static final Logger logger = LoggerFactory.getLogger(ZeusRegister.class);

    private final ServiceDiscovery<ServiceInstanceDetail> serviceDiscovery;

    public ZeusRegister(CuratorFramework client, String basePath) throws Exception {
        CuratorServiceInstanceSerializer serializer = new CuratorServiceInstanceSerializer(ServiceInstanceDetail.class);
        this.serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceInstanceDetail.class).client(client).serializer(serializer).basePath(basePath).build();
        this.serviceDiscovery.start();
        logger.info("zookeeper ServiceRegister start success");
    }

    @Override
    public void registerService(String hostName, String ip, String port, String classPath, String methodPath, String serviceName, String serviceGroup) {
        ServiceInstanceDetail detail = new ServiceInstanceDetail(hostName,ip,port,classPath,methodPath,serviceName,serviceGroup);
        try {
            ServiceInstance serviceInstance = ServiceInstance.builder().name(serviceName).address(ip).port(Integer.valueOf(port)).payload(detail).build();
            serviceDiscovery.registerService(serviceInstance);
        } catch (Exception e) {
            logger.error("{} register error {}",serviceName,e);
        }
    }
}
