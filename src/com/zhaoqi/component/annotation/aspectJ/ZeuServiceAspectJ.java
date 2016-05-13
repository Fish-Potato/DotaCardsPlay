package com.zhaoqi.component.annotation.aspectJ;


import com.weibo.api.motan.config.RegistryConfig;
import com.zhaoqi.component.annotation.ZeuService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by zhaoqi on 2016/5/11.
 */
@Aspect
@Component
public class ZeuServiceAspectJ implements InitializingBean{
    private static final Properties prop =new Properties();
    @Around("@annotation(annotation)")
    public Object advice(ProceedingJoinPoint joinPoint, ZeuService annotation) throws Throwable {

        registerToMotan(joinPoint, annotation);
        return joinPoint.proceed();
    }

    private void registerToMotan(ProceedingJoinPoint joinPoint, ZeuService annotation) {
        Class clazz = joinPoint.getSignature().getDeclaringType();

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setRegProtocol("local");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        prop.load(getClass().getResourceAsStream("META-INF/config/zk-server.properties"));
    }
}
