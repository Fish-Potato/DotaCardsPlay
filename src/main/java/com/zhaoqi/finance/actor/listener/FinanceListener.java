package com.zhaoqi.finance.actor.listener;

import akka.actor.UntypedActor;
import com.alibaba.fastjson.JSON;
import com.zhaoqi.finance.actor.message.listener.CommonListenerMessage;

/**
 * Created by onefish on 2016/11/18 0018.
 * 支付系统监听器
 * 监听和记录支付相关的操作
 * 考虑到支付的重要性
 * 每一步金钱相关的操作都需要记录
 */
public class FinanceListener extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Throwable {
        if (o instanceof CommonListenerMessage) {
            writeCommonListenerMessage((CommonListenerMessage) o);
        }
    }

    private void writeCommonListenerMessage(CommonListenerMessage commonListenerMessage) {
        // write to mongoDB or log or mysql etc.
        System.out.println(JSON.toJSONString(commonListenerMessage));
    }
}
