package com.zhaoqi.model.common;

import com.zhaoqi.model.skill.SkillDurationTime;

/**
 * Created by zhaoqi on 2016/4/26.
 * 技能伤害方式
 */
public class DamageMethod {
    // 施法目标（单人，范围）
    private String spellTarget;

    // 技能伤害持续时间
    private SkillDurationTime skillDurationTime;

    // 伤害类型(魔法，物理，纯粹)
    private String damageType;

    public String getSpellTarget() {
        return spellTarget;
    }

    public void setSpellTarget(String spellTarget) {
        this.spellTarget = spellTarget;
    }

    public SkillDurationTime getSkillDurationTime() {
        return skillDurationTime;
    }

    public void setSkillDurationTime(SkillDurationTime skillDurationTime) {
        this.skillDurationTime = skillDurationTime;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }
}
