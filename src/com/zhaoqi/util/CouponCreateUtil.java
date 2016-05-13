package com.zhaoqi.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaoqi on 2016/5/13.
 * 优惠券号生成Util（弱依赖数据库）
 */
public class CouponCreateUtil implements InitializingBean{
    private static AtomicInteger couponId ;

    private static int maxIncrement = 10000;

    private static AtomicInteger count;

    private static Object mutex;

    private static String localIp;

    public static String getCoupon(){
        if (null == couponId) {
            // exception
            return null;
        }
        int cId = couponId.getAndIncrement();
        if(count.getAndIncrement() >= maxIncrement) {
            synchronized (mutex) {
                getCouponIdFromDb();
            }
        }
        return encodeCouponNumber(cId);
    }

    private static String encodeCouponNumber(int cId) {
        // encode cId & localIp
        return String.valueOf(cId);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 多点部署获取当前ip
        localIp = "1";
        getCouponIdFromDb();
    }

    @Transactional
    private static void getCouponIdFromDb() {
        couponId = new AtomicInteger(11); // read from database
        maxIncrement = 10000; // read from xml or database
        count = new AtomicInteger(0);
        // 回写couponId+maxIncreasment（+误差）值
    }
}
