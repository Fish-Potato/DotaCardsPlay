package com.zhaoqi.model.common;

/**
 * Created by zhaoqi on 2016/4/27.
 */
public class Player {
    // 游戏币
    private int gold;
    // 水晶（RMB）
    private int crystal;
    // 玩家等级
    private int level;
    // 会员等级
    private int memberLevel;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getCrystal() {
        return crystal;
    }

    public void setCrystal(int crystal) {
        this.crystal = crystal;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }
}
