package com.zhaoqi.finance.manager;

import akka.actor.*;
import com.zhaoqi.finance.actor.BaseActor;
import com.zhaoqi.finance.actor.EarnestMoneyActor;
import com.zhaoqi.finance.actor.FinanceManagerActor;
import com.zhaoqi.finance.actor.message.request.CollectEarnestMoney;
import com.zhaoqi.finance.manager.request.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by onefish on 2016/11/17 0017.
 */
@Service
public class FinanceActorManager {

    public void collectEarnestMoney(CollectEarnestMoney collectEarnestMoney) {
        ActorRef actorRef = BaseActor.create(Props.create(FinanceManagerActor.class));
        actorRef.tell(collectEarnestMoney,ActorRef.noSender());
    }
}
