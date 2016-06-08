package com.zhaoqi.model.skill;

/**
 * Created by zhaoqi on 2016/4/27.
 */
public class Skill {
    // 技能id
    private int skillId;

    // 技能名称
    private String skillName;

    // 技能描述
    private String skillDescription;

    // 技能伤害(单次伤害)
    private float damage;

    // 技能快捷键
    private char skillShortCut;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public char getSkillShortCut() {
        return skillShortCut;
    }

    public void setSkillShortCut(char skillShortCut) {
        this.skillShortCut = skillShortCut;
    }
}
