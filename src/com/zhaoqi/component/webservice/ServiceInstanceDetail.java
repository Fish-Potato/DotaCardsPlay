package com.zhaoqi.component.webservice;

/**
 * Created by zhaoqi on 2016/5/13.
 */
public class ServiceInstanceDetail {

    private String localHostName;

    private String localIp;

    private String localPort;

    private String classPath;

    private String methodPath;

    private String serviceName;

    private String serviceGroup;

    public ServiceInstanceDetail(String localHostName, String localIp, String localPort, String classPath, String methodPath, String serviceName, String serviceGroup) {
        this.localHostName = localHostName;
        this.localIp = localIp;
        this.localPort = localPort;
        this.classPath = classPath;
        this.methodPath = methodPath;
        this.serviceName = serviceName;
        this.serviceGroup = serviceGroup;
    }

    public ServiceInstanceDetail() {

    }

    public ServiceInstanceDetail(String localIp,String localPort,String serviceName) {
        this.localIp = localIp;
        this.localPort = localPort;
        this.serviceName = serviceName;
    }

    public String getLocalHostName() {
        return localHostName;
    }

    public void setLocalHostName(String localHostName) {
        this.localHostName = localHostName;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public String getLocalPort() {
        return localPort;
    }

    public void setLocalPort(String localPort) {
        this.localPort = localPort;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public void setMethodPath(String methodPath) {
        this.methodPath = methodPath;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }
}
