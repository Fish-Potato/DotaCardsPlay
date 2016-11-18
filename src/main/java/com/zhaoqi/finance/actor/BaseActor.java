package com.zhaoqi.finance.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.zhaoqi.finance.actor.listener.FinanceListener;
import com.zhaoqi.finance.manager.FinanceActorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by onefish on 2016/11/18 0018.
 * 生成ActorRef
 * 生成FinanceListener
 */
@Service
public class BaseActor {

    private static Logger logger = LoggerFactory.getLogger(BaseActor.class);

    private static ActorSystem actorSystem;

    private static ActorRef financeListener;

    @PostConstruct
    private void init() {
        if (null == actorSystem) {
            synchronized (FinanceActorManager.class) {
                if (null == actorSystem) {
                    actorSystem = ActorSystem.create("Finance");
                }
            }
        }
    }

    public static ActorRef create(Props props){
        if (null == actorSystem) {
            logger.error("ActorSystem has not been initialed");
        }
        return actorSystem.actorOf(props);
    }

    public static ActorRef getFinanceListener(){
        return actorSystem.actorOf(Props.create(FinanceListener.class));
    }
}
