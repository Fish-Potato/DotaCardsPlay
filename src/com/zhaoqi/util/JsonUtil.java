package com.zhaoqi.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;

import java.util.HashSet;
import java.util.Set;


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
        if(isSimpleType(clazz)) {
            return handlerSimpleType(param,clazz);
        } else {
            t = toObject(param, clazz,new Feature[0]);
        }
        return t;
    }
    public static <T> T toObject(String param,Class<T> clazz,Feature... features) {
        T t = null;
        if(isSimpleType(clazz)) {
            return handlerSimpleType(param,clazz);
        } else {
            t = toObject(param, clazz, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
        }
        return t;
    }

    public static <T> T toObject(String param, Class<T> clazz, ParserConfig config, int featureValues,
                                 Feature... features) {
        T t = null;
        if(isSimpleType(clazz)) {
            return handlerSimpleType(param,clazz);
        } else {
            t = toObject(param, clazz, ParserConfig.getGlobalInstance(), null, JSON.DEFAULT_PARSER_FEATURE, features);
        }
        return t;
    }

    public static <T> T toObject(String param, Class<T> clazz, ParserConfig config, ParseProcess processor,
                                 int featureValues, Feature... features) {
        T t = null;
        if(isSimpleType(clazz)) {
            return handlerSimpleType(param,clazz);
        } else {
            t = JSON.parseObject(param, clazz, config, processor, featureValues, features);
        }
        return t;
    }


    @SuppressWarnings("unchecked")
    private static <T> T handlerSimpleType(String param, Class<T> clazz) {
        T t = null;
        JSONObject jsonObject =(JSONObject) JSON.parse(param);
        return (T)jsonObject.get(jsonObject.keySet().iterator().next());
    }

    private static <T> boolean isSimpleType(Class<T> clazz) {
        Set<Object> clazzSet = new HashSet<Object>(){{add(String.class);add(Integer.class);add(Boolean.class);add(Long.class);add(Short.class);}};
        return clazzSet.contains(clazz);
    }
}
