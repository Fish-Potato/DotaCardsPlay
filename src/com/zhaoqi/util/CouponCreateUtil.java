package com.zhaoqi.util;

import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaoqi on 2016/5/13.
 * 优惠券号生成Util（弱依赖数据库）
 */
public class CouponCreateUtil implements InitializingBean{
    private static AtomicDouble couponId ;

    private static int maxIncrement = 10000;

    private static AtomicInteger count;

    private static Object mutex;

    private static String localIp;

    public static String getCoupon(){
        if (null == couponId) {
            // exception
            return null;
        }
        double cId = couponId.getAndAdd(1);
        if(count.getAndIncrement() >= maxIncrement) {
            synchronized (mutex) {
                getCouponIdFromDb();
            }
        }
        return encodeCouponNumber(String.valueOf(cId));
    }

//    public static String encodeCouponNumber(String cId) {
//        BigDecimal couponId = new BigDecimal(cId);
//        couponId.setScale(0,BigDecimal.ROUND_DOWN);
//        // 10进制转36进制
//        char[] codeTemplate = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
//                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
//        StringBuffer encodedStr = new StringBuffer();
//        while (couponId.compareTo(BigDecimal.ZERO)>0) {
//            encodedStr.insert(0,codeTemplate[(couponId.remainder(new BigDecimal(36)).intValue())]);
//            couponId = couponId.divide(new BigDecimal(36));
//        }
//        // encode cId & localIp
//        return StringUtils.isEmpty(String.valueOf(encodedStr))?"0":String.valueOf(encodedStr);
//    }

    public static String encodeCouponNumber(String cId) {
        BigInteger couponId = new BigInteger(cId);
        // 10进制转36进制
        char[] codeTemplate = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        StringBuffer encodedStr = new StringBuffer();
        while (couponId.compareTo(BigInteger.ZERO)>0) {
            encodedStr.insert(0,codeTemplate[couponId.remainder(BigInteger.valueOf(36)).intValue()]);
            couponId = couponId.divide(BigInteger.valueOf(36));
        }
        // encode cId & localIp
        return StringUtils.isEmpty(String.valueOf(encodedStr))?"0":String.valueOf(encodedStr);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 多点部署获取当前ip，最好配置一下xml简化ip:port 用key来代替
        localIp = "1";
        // 多点部署的话，配置分别读取
        getCouponIdFromDb();
    }

    @Transactional
    private static void getCouponIdFromDb() {
        couponId = new AtomicDouble(456469878979d); // read from database
        maxIncrement = 10000; // read from xml or database
        count = new AtomicInteger(0);
        // 回写couponId+maxIncreasment（+误差）值
    }
}
