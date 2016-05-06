package com.zhaoqi.model.common;

/**
 * Created by zhaoqi on 2016/4/27.
 */
public class Probability {
    private float probabilityValue;
    private boolean isPseudoRandom;

    public boolean isPseudoRandom() {
        return isPseudoRandom;
    }

    public void setPseudoRandom(boolean pseudoRandom) {
        isPseudoRandom = pseudoRandom;
    }

    public float getProbabilityValue() {
        return probabilityValue;
    }

    public void setProbabilityValue(float probabilityValue) {
        this.probabilityValue = probabilityValue;
    }
}
