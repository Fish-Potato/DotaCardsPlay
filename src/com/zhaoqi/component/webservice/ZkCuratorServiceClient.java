package com.zhaoqi.component.webservice;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;

import java.io.Closeable;
import java.util.List;

/**
 * Created by zhaoqi on 2016/5/13.
 */
public class ZkCuratorServiceClient {

    private ServiceDiscovery<ServiceInstanceDetail> serviceDiscovery;
    private List<Closeable> closeableList = Lists.newArrayList();
    private Object lock = new Object();
    private String basePath;
    private String zkAddress;
    private CuratorFramework client;

    public ZkCuratorServiceClient(CuratorFramework client, String basePath) throws Exception {
        this.client =client;
        this.basePath = basePath;
        this.zkAddress = client.getZookeeperClient().getCurrentConnectionString();
        CuratorServiceInstanceSerializer serializer = new CuratorServiceInstanceSerializer(ServiceInstanceDetail.class);
        this.serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceInstanceDetail.class).client(client).basePath(basePath).serializer(serializer).build();
        serviceDiscovery.start();
    }

    public ServiceInstanceDetail getServiceByName(String serviceName) {
        return null;
    }

}
