package com.zhaoqi.finance.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.zhaoqi.finance.actor.message.request.CollectEarnestMoney;

/**
 * Created by onefish on 2016/11/18 0018.
 */
public class FinanceManagerActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Throwable {
        // 收取诚意金
        if (o instanceof CollectEarnestMoney) {
            doCollectEarnestMoney((CollectEarnestMoney) o);
        }
    }

    private void doCollectEarnestMoney(CollectEarnestMoney collectEarnestMoney) {
        ActorRef listener = BaseActor.getFinanceListener();
        // 创建诚意金actor
        final ActorRef earnestMoneyActor = BaseActor.create(Props.create(EarnestMoneyActor.class,listener));
        // 传递信息给诚意金actor
        earnestMoneyActor.tell(collectEarnestMoney,ActorRef.noSender());
    }


}
