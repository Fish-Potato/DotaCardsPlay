package com.zhaoqi.util;

import com.zhaoqi.component.http.DotaHttpClient;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhaoqi on 2016/4/28.
 */
public class RestUtil {

    private static final int CONNECTION_TIME_OUT = 3;
    private static final int READ_TIME_OUT = 10;

    public static <T> T send(Object params, String url, Class<T> clazz) {
        return send(params, url, RequestMethod.GET, clazz);
    }

    public static <T> T send(Object params, String url, RequestMethod method, Class<T> clazz) {
        return send(params, url, method, clazz, CONNECTION_TIME_OUT);
    }

    public static <T> T send(Object params, String url, RequestMethod method, Class<T> clazz,int connectionTimeout) {
        return send(params, url, method, clazz, connectionTimeout, READ_TIME_OUT);
    }

    public static <T> T send(Object params, String url, RequestMethod method, Class<T> clazz,int connectionTimeout,int readTimeOut) {
        return DotaHttpClient.send(params,url,method,clazz,connectionTimeout,readTimeOut);
    }


}
