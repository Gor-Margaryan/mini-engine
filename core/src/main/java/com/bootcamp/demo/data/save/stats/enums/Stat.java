package com.bootcamp.demo.data.save.stats.enums;

import lombok.Getter;

@Getter
public enum Stat {

    HP(StatType.ADDITIVE),
    ATK(StatType.ADDITIVE),
    DODGE(StatType.MULTIPLICATIVE),
    COMBO(StatType.MULTIPLICATIVE),
    CRIT(StatType.MULTIPLICATIVE),
    STUN(StatType.MULTIPLICATIVE),
    REGEN(StatType.MULTIPLICATIVE),
    STEAL(StatType.MULTIPLICATIVE),
    POISON(StatType.MULTIPLICATIVE);

    @Getter
    final StatType statType;

     Stat(StatType statType){
        this.statType = statType;
    }


}
