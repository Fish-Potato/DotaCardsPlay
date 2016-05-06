package com.zhaoqi.exercises.services;


import com.zhaoqi.dotaInterface.common.SkillEffectObject;
import com.zhaoqi.model.skill.HeroSkill;

/**
 * Created by zhaoqi on 2016/4/27.
 */
public interface PutSkills {
    // 释放技能
    public void putSkills(SkillEffectObject source, HeroSkill skill, SkillEffectObject target);
}
