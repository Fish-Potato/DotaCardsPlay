package com.zhaoqi.model.common;


/**
 * Created by zhaoqi on 2016/4/27.
 */
public class Critical {
    // 暴击概率
    private Probability criticalProbability;
    // 暴击倍数
    private float criticalMulti;

    public Probability getCriticalProbability() {
        return criticalProbability;
    }

    public void setCriticalProbability(Probability criticalProbability) {
        this.criticalProbability = criticalProbability;
    }

    public float getCriticalMulti() {
        return criticalMulti;
    }

    public void setCriticalMulti(float criticalMulti) {
        this.criticalMulti = criticalMulti;
    }
}
