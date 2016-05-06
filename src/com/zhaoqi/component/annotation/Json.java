package com.zhaoqi.component.annotation;

import java.lang.annotation.*;

/**
 * Created by zhaoqi on 2016/5/5.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Json {

    Class[] types() default java.lang.Object.class;

    String path() default "";
}
