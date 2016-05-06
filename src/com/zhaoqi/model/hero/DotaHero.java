package com.zhaoqi.model.hero;


import com.zhaoqi.dotaInterface.common.SkillEffectObject;
import com.zhaoqi.model.common.Critical;

import java.util.List;

/**
 * Created by zhaoqi on 2016/4/26.
 * dota英雄
 */
public class DotaHero implements SkillEffectObject {
    // 力量
    private float strength ;
    // 敏捷
    private float agility ;
    // 智力
    private float intelligence;
    // 力量成长
    private float strengthGrowth;
    // 敏捷成长
    private float agilityGrowth;
    // 智力成长
    private float intelligenceGrowth;
    // 英雄名称
    private String heroName;
    // 英雄id
    private String heroId;
    // 最低攻击力
    private float lowerAttack;
    // 最高攻击力
    private float higherAttack;
    // 护甲
    private float shield;
    // 魔抗
    private float  magicResist;
    // 暴击(暴击可能有多个，且需要独立计算 eg.水晶剑配恩赐解脱)
    private List<Critical> criticals;

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public float getAgility() {
        return agility;
    }

    public void setAgility(float agility) {
        this.agility = agility;
    }

    public float getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(float intelligence) {
        this.intelligence = intelligence;
    }

    public float getStrengthGrowth() {
        return strengthGrowth;
    }

    public void setStrengthGrowth(float strengthGrowth) {
        this.strengthGrowth = strengthGrowth;
    }

    public float getAgilityGrowth() {
        return agilityGrowth;
    }

    public void setAgilityGrowth(float agilityGrowth) {
        this.agilityGrowth = agilityGrowth;
    }

    public float getIntelligenceGrowth() {
        return intelligenceGrowth;
    }

    public void setIntelligenceGrowth(float intelligenceGrowth) {
        this.intelligenceGrowth = intelligenceGrowth;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public float getLowerAttack() {
        return lowerAttack;
    }

    public void setLowerAttack(float lowerAttack) {
        this.lowerAttack = lowerAttack;
    }

    public float getHigherAttack() {
        return higherAttack;
    }

    public void setHigherAttack(float higherAttack) {
        this.higherAttack = higherAttack;
    }

    public float getShield() {
        return shield;
    }

    public void setShield(float shield) {
        this.shield = shield;
    }

    public float getMagicResist() {
        return magicResist;
    }

    public void setMagicResist(float magicResist) {
        this.magicResist = magicResist;
    }

    public List<Critical> getCriticals() {
        return criticals;
    }

    public void setCriticals(List<Critical> criticals) {
        this.criticals = criticals;
    }
}
