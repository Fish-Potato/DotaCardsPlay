package com.zhaoqi.exercises.services.impl;

import com.zhaoqi.dotaInterface.common.SkillEffectObject;
import com.zhaoqi.model.skill.HeroSkill;
import com.zhaoqi.exercises.annotation.Check;
import com.zhaoqi.exercises.model.CheckConstants;
import com.zhaoqi.exercises.services.PutSkills;
import org.springframework.stereotype.Component;


/**
 * Created by zhaoqi on 2016/4/27.
 */
@Component
public class PutSkillsImpl implements PutSkills {

    @Check(checkLevel = CheckConstants.NO_SUSPEND,checkType = CheckConstants.SKILL)
    public void putSkills(SkillEffectObject source, HeroSkill skill, SkillEffectObject target) {
        System.out.println("source put skill to target");
        return ;
    }
}
