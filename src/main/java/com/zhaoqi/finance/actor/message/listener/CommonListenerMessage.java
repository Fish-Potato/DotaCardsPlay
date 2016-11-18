package com.zhaoqi.finance.actor.message.listener;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by onefish on 2016/11/18 0018.
 */
public class CommonListenerMessage implements Serializable{

    // 记录的消息
    private String message;

    // 用户id
    private String userId;

    // 操作类型
    private String opType;

    // 金额大小
    private BigDecimal amount;

    private String orderId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class CommonListenerMessageBuilder {
        CommonListenerMessage commonListenerMessage;

        public CommonListenerMessageBuilder(){
            commonListenerMessage = new CommonListenerMessage();
        }
        public CommonListenerMessageBuilder userId(String userId){
            commonListenerMessage.userId = userId;
            return this;
        }

        public CommonListenerMessageBuilder message(String message){
            commonListenerMessage.message = message;
            return this;
        }
        public CommonListenerMessageBuilder opType(String opType){
            commonListenerMessage.opType = opType;
            return this;
        }

        public CommonListenerMessageBuilder orderId(String orderId){
            commonListenerMessage.orderId = orderId;
            return this;
        }

        public CommonListenerMessageBuilder amount(BigDecimal amount){
            commonListenerMessage.amount = amount;
            return this;
        }

        public CommonListenerMessage build(){
            return commonListenerMessage;
        }

    }
}
