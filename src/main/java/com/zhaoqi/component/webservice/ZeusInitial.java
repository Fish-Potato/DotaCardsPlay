package com.zhaoqi.component.webservice;

import com.zhaoqi.component.annotation.ZeuService;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoqi on 2016/5/17.
 */
public class ZeusInitial implements ApplicationContextAware , InitializingBean{

    private static final Logger logger = LoggerFactory.getLogger(ZeusInitial.class);
    private static Map<String, Object> ZeusServices = new HashMap<>();

    private String port;
    private IRegister register;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ZeusServices.putAll(applicationContext.getBeansWithAnnotation(ZeuService.class));
        logger.info("zeus service initialing , find all zeus service {}", ZeusServices);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String localIp = InetAddress.getLocalHost().getHostAddress();
        String localHostName = InetAddress.getLocalHost().getHostName();
        String localPort = port;
        for (Object service : ZeusServices.values()) {

            RequestMapping requestMapping =AnnotationUtils.findAnnotation(service.getClass(), RequestMapping.class);
            String classPath = getPath(requestMapping);

            Method[] methods = ReflectionUtils.getAllDeclaredMethods(service.getClass());

            for (Method method: methods) {
                RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
                ZeuService zeuService = AnnotationUtils.findAnnotation(service.getClass(),ZeuService.class);
                String serviceName = zeuService.value();
                String serviceGroup = zeuService.group();
                if (null != methodRequestMapping) {
                    String methodPath = getPath(methodRequestMapping);
                    register.registerService(localHostName,localIp,localPort,classPath,methodPath,serviceName,serviceGroup);
                }
            }
        }
    }

    private static final String getPath(RequestMapping requestMapping) {
        if(requestMapping == null) {
            return null;
        } else {
            String[] path = requestMapping.path();
            if(ArrayUtils.isNotEmpty(path)) {
                return path[0];
            } else {
                String[] value = requestMapping.value();
                return ArrayUtils.isNotEmpty(value)?value[0]:null;
            }
        }
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setRegister(IRegister register) {
        this.register = register;
    }
}
