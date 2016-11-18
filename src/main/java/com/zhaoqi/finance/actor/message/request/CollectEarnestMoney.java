package com.zhaoqi.finance.actor.message.request;

import java.math.BigDecimal;

/**
 * Created by onefish on 2016/11/17 0017.
 */
public class CollectEarnestMoney {
    private String userId;
    private BigDecimal amount;
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
