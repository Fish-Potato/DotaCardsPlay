package com.actor;

import com.zhaoqi.finance.actor.message.request.CollectEarnestMoney;
import com.zhaoqi.finance.manager.FinanceActorManager;

import java.math.BigDecimal;

/**
 * Created by onefish on 2016/12/7 0007.
 */
public class ActorThread extends Thread {
    private FinanceActorManager financeActorManager;
    private int count;
    public ActorThread(FinanceActorManager financeActorManager, int count) {
        this.financeActorManager=financeActorManager;
        this.count = count;
    }
    @Override
    public void run() {
        CollectEarnestMoney collectEarnestMoney = new CollectEarnestMoney();
        collectEarnestMoney.setUserId("10");
        collectEarnestMoney.setOrderId("201601");
        collectEarnestMoney.setAmount(BigDecimal.valueOf(count));
        financeActorManager.collectEarnestMoney(collectEarnestMoney);
    }
}
