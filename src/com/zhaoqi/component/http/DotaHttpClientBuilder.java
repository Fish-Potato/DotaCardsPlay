package com.zhaoqi.component.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoqi on 2016/4/28.
 */
public class DotaHttpClientBuilder {


    public static String sendRequest(String args, String url, RequestMethod method, int connectionTimeout, int readTimeOut) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(readTimeOut).build();
        CloseableHttpResponse response;
        if(method.equals(RequestMethod.POST)) {
            response = executePost(args, url, requestConfig);
        }
        else {
            response = executeGet(args, url, requestConfig);
        }
        if (null != response) {
            try {
                return  EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static CloseableHttpResponse executePost(String args, String url, RequestConfig requestConfig) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("args",args));
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
            return response;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static CloseableHttpResponse executeGet(String args, String url, RequestConfig requestConfig) {
        HttpGet httpGet = new HttpGet(url+"?"+args);
        httpGet.setConfig(requestConfig);
        CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
        try {
            CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
