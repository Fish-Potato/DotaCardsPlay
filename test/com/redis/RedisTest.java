package com.redis;

import com.google.common.collect.Lists;
import com.tts.component.redis.GracefulRedisTemplate;
import com.tts.util.JsonUtil;
import com.zhaoqi.controller.test.redis.RedisTestController;
import com.zhaoqi.controller.test.redis.model.RedisTestRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoqi on 2016/8/12 0012.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:META-INF/spring/spring*.xml"})
public class RedisTest {
    @Resource
    private GracefulRedisTemplate redisTemplate;

    @Resource
    private RedisTestController redisTestController;

    @Test
    public void test() throws InterruptedException {
        Map<String,String> kvs = new HashMap<>();
        for (int i=0;i<3;i++) {
            String key = randomStr();
            String value = randomStr();
            redisTemplate.setEx(key,value,60);
            kvs.put(key,value);
        }
        Thread.sleep(5000);
        System.out.println(JsonUtil.toString(redisTemplate.mget(Lists.newArrayList(kvs.keySet()),String.class)));
        redisTemplate.delete(kvs.keySet());
    }

    @Test
    public void test1() {
        RedisTestRequest redisTestRequest = JsonUtil.toObject("{\"a\":\"hehe\",\"b\":1,\"c\":[\"yes\",\"no\"],\"helloRequest\":{\"hello\":\"hello world!\"}}",RedisTestRequest.class);
        System.out.println(redisTestController.getFeedback(redisTestRequest));
    }

    private String randomStr(){
        char[] chars ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<10;i++) {
            sb.append(chars[(int)(Math.random()*chars.length)]);
        }
        return sb.toString();
    }

}
