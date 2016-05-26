package com.zhaoqi.component.webservice;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhaoqi.component.annotation.ZeuService;

/**
 * Created by zhaoqi on 2016/5/17.
 */
public class ZeusInitial implements ApplicationContextAware , InitializingBean{

    private static final Logger logger = LoggerFactory.getLogger(ZeusInitial.class);
    private static Map<String, Object> zeusServices = new HashMap<>();

    private String port;
    private IRegister register;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        zeusServices.putAll(applicationContext.getBeansWithAnnotation(Controller.class));
        zeusServices.putAll(applicationContext.getBeansWithAnnotation(RestController.class));
        logger.info("zeus service initialing , find all zeus service {}", zeusServices);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String localIp = InetAddress.getLocalHost().getHostAddress();
        String localHostName = InetAddress.getLocalHost().getHostName();
        String localPort = port;
        for (Object service : zeusServices.values()) {

            RequestMapping requestMapping =AnnotationUtils.findAnnotation(service.getClass(), RequestMapping.class);
            String classPath = getPath(requestMapping);

            Method[] methods = ReflectionUtils.getAllDeclaredMethods(service.getClass());

            for (Method method: methods) {
                // 没有ZeuService注解的不注册
                if (null == method.getAnnotation(ZeuService.class)) {
                    continue;
                }
                RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
                ZeuService zeuService = method.getAnnotation(ZeuService.class);
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
