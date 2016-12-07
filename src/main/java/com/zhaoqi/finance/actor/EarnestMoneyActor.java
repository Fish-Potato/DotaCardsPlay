package com.zhaoqi.finance.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.zhaoqi.finance.actor.message.listener.CommonListenerMessage;
import com.zhaoqi.finance.actor.message.request.CollectEarnestMoney;
import com.zhaoqi.finance.actor.message.request.EarnestMoneyToDeposit;
import com.zhaoqi.finance.actor.message.request.RefundEarnestMoney;

/**
 * Created by onefish on 2016/11/17 0017.
 */
public class EarnestMoneyActor extends UntypedActor {

    private ActorRef listener;

    public EarnestMoneyActor(ActorRef listener){
        this.listener = listener;
    }

    @Override
    public void onReceive(Object o) throws Throwable {
        if (o instanceof CollectEarnestMoney) {
            doCollectEarnestMoney((CollectEarnestMoney) o);
        }
        if (o instanceof RefundEarnestMoney) {
            doRefundEarnestMoney((RefundEarnestMoney) o);
        }
        if (o instanceof EarnestMoneyToDeposit) {
            doEarnestMoneyToDeposit((EarnestMoneyToDeposit) o);
        } else {
            unhandled(o);
        }
    }

    private void doRefundEarnestMoney(RefundEarnestMoney o) {
        // 查询已交诚意金

        // 退款金额 > 已交金额 --> 退款失败

        // 执行退款 --> 退款成功
    }

    private void doEarnestMoneyToDeposit(EarnestMoneyToDeposit earnestMoneyToDeposit) {
        // 减少诚意金

        // method 1:发送消息给定金actor增加定金 (可以实现高并发，但存在数据不一致的问题-->可以通过listener实现补偿或者回滚来实现数据一致性)

        // method 2:用事务和乐观锁，同时更新诚意金和定金的金额(保证数据一致性，考虑到只有诚意金转定金，不会产生死锁，效率也OK)

        // method 3:不需要事务，一个update语句同时更新这两个表（必须同一个库）
    }

    private void doCollectEarnestMoney(CollectEarnestMoney earnestMoneyIncrease) {
        // 收取诚意金

        // 记录信息
        CommonListenerMessage commonListenerMessage = new CommonListenerMessage.CommonListenerMessageBuilder()
                .amount(earnestMoneyIncrease.getAmount())
                .message("收取诚意金："+earnestMoneyIncrease.getAmount().toString()+"元")
                .opType("CollectEarnestMoney")
                .userId(earnestMoneyIncrease.getUserId())
                .orderId(earnestMoneyIncrease.getOrderId())
                .build();
        listener.tell(commonListenerMessage,ActorRef.noSender());
        listener.tell(earnestMoneyIncrease.getAmount().intValue(),ActorRef.noSender());
    }

}
