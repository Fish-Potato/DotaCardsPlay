package com.zhaoqi.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhaoqi on 2016/4/28.
 */
public class JsonUtil {
    public static String toString(Object o) {
        return JSON.toJSONString(o);
    }

    @SuppressWarnings("unchecked")
    public static <T> T toObject(String param,Class<T> clazz) {
        T t = null;
        if (clazz.equals(String.class)) {
            t = (T) param;
        } else if (clazz.equals(Integer.class)) {
            t = (T) Integer.valueOf(param);
        } else {
            t = JSON.parseObject(param, clazz);
        }
        return t;
    }
}
