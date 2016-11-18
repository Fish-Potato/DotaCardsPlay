package com.zhaoqi.finance.manager;

import com.zhaoqi.finance.manager.request.FinanceInRequest;
import com.zhaoqi.finance.manager.request.FinanceOutRequest;

/**
 * Created by onefish on 2016/11/17 0017.
 */
public interface ActorManager {

    Object moneyIn(FinanceInRequest request);

    Object moneyOut(FinanceOutRequest request);
}
