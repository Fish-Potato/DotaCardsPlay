package com.actor;

import com.BaseTest;
import com.zhaoqi.finance.actor.message.request.CollectEarnestMoney;
import com.zhaoqi.finance.manager.FinanceActorManager;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by onefish on 2016/11/18 0018.
 */
public class ActorTest extends BaseTest{

    @Resource
    private FinanceActorManager financeActorManager;

    @Test
    public void testActor(){
        CollectEarnestMoney collectEarnestMoney = new CollectEarnestMoney();
        collectEarnestMoney.setUserId("10");
        collectEarnestMoney.setOrderId("201601");
        collectEarnestMoney.setAmount(BigDecimal.valueOf(100));
        financeActorManager.collectEarnestMoney(collectEarnestMoney);
        // 休眠5秒，防止ActorSystem随着主线程结束而shutdown
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
