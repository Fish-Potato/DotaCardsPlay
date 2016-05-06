package com.zhaoqi.exercises.annotation;

import java.lang.annotation.*;

/**
 * Created by zhaoqi on 2016/4/27.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@Inherited
@Documented
public @interface Check {
    String checkType() default "";

    String checkLevel() default "";
}
