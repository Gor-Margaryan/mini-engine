package com.bootcamp.demo.data.game.tactics.enums;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;

public enum TacticAndFlagAndPetRarity {
    COMMON(Color.valueOf("#a28d7a"),1),
    COMMON_2(Color.valueOf("#a28d7a"),2),
    RARE(Color.valueOf("#5f98c3"),1),
    RARE_2(Color.valueOf("#5f98c3"),2),
    EPIC(Color.valueOf("#b792c8"),1),
    EPIC_2(Color.valueOf("#b792c8"),2),
    LEGENDARY(Color.valueOf("#e5ad4d"),1),
    LEGENDARY_2(Color.valueOf("#e5ad4d"),2),
    EXOTIC(Color.valueOf("#d95955"),1),
    EXOTIC_2(Color.valueOf("#d95955"),2);

    @Getter
    private final Color color;
    @Getter
    private final int starCount;

    TacticAndFlagAndPetRarity(Color color,int starCount) {
        this.color = color;
        this.starCount = starCount;
    }
}
