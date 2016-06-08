package com.zhaoqi.model.skill;

/**
 * Created by zhaoqi on 2016/4/26.
 * 技能持续时间
 */
public class SkillDurationTime {

    // 技能作用方式(1次伤害，多次伤害)
    private String effectMethod;

    // 技能作用次数
    private int effectTimes;

    // 技能持续时间
    private float effectDuration;

    public String getEffectMethod() {
        return effectMethod;
    }

    public void setEffectMethod(String effectMethod) {
        this.effectMethod = effectMethod;
    }

    public int getEffectTimes() {
        return effectTimes;
    }

    public void setEffectTimes(int effectTimes) {
        this.effectTimes = effectTimes;
    }

    public float getEffectDuration() {
        return effectDuration;
    }

    public void setEffectDuration(float effectDuration) {
        this.effectDuration = effectDuration;
    }
}
