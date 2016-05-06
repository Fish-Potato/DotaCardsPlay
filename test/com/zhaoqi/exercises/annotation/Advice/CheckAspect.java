package com.zhaoqi.exercises.annotation.Advice;

import com.zhaoqi.exercises.annotation.Check;
import com.zhaoqi.exercises.model.CheckConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoqi on 2016/4/27.
 */
@Aspect
@Component
public class CheckAspect {

    @Around("@annotation(annotation)")
    public Object advice(ProceedingJoinPoint joinPoint, Check annotation) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final Class<?> clazz = signature.getClass();
        try {
            if (CheckConstants.SUSPEND.equals(annotation.checkLevel())) {
                if(this.check()) {
                    return joinPoint.proceed();
                } else {
                    System.out.println("校验未通过");
                }
            } else {
                return joinPoint.proceed();
            }
        } catch (Exception e) {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
//            logger.error("invoke className:{} method failed methodName{}:", new Object[] { targetName, methodName }, e);
            System.out.println("invoke className:"+targetName+" method failed methodName:"+methodName);
            e.printStackTrace();
            throw new RuntimeException("invoke method failed:" + methodName, e);
        }
        return null;
    }

    private boolean check() {
        return false;
    }


}
