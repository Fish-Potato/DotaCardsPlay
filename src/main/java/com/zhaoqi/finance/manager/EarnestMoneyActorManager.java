//package com.zhaoqi.finance.manager;
//
//import akka.actor.*;
//import akka.japi.Creator;
//import com.zhaoqi.finance.actor.EarnestMoneyActor;
//import com.zhaoqi.finance.manager.request.EarnestMoneyInRequest;
//import com.zhaoqi.finance.manager.request.EarnestMoneyOutRequest;
//import com.zhaoqi.finance.manager.request.FinanceInRequest;
//import com.zhaoqi.finance.manager.request.FinanceOutRequest;
//import org.springframework.stereotype.Service;
//
///**
// * Created by onefish on 2016/11/17 0017.
// */
//@Service
//public class EarnestMoneyActorManager extends FinanceActorManager implements ActorManager{
//
//    @Override
//    public Object moneyIn(FinanceInRequest request) {
//        if (!(request instanceof EarnestMoneyInRequest)) {
//            return null;
//        }
//        //
//        return null;
//    }
//
//    @Override
//    public Object moneyOut(FinanceOutRequest request) {
//        return null;
//    }
//
//    private void init() {
//        ActorSystem actorSystem = ActorSystem.create("EarnestMoney");
//        ActorRef earnestMoneyActor = actorSystem.actorOf(Props.create(new Creator<Actor>() {
//            @Override
//            public Actor create() throws Exception {
//                return new EarnestMoneyActor();
//            }
//        }));
//    }
//}
