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

    @Test
    public void testActorParallel(){
        long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i =0;i<10000;i++) {
            ActorThread t = new ActorThread(financeActorManager,i);
            t.start();
        }
        System.out.println("耗时"+(System.currentTimeMillis()-start));
        // 休眠5秒，防止ActorSystem随着主线程结束而shutdown
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
