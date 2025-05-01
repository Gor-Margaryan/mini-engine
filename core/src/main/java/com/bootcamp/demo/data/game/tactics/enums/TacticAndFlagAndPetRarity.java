package com.bootcamp.demo.data.game.tactics.enums;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;

public enum TacticAndFlagAndPetRarity {
    COMMON(Color.valueOf("#a28d7a")),
    RARE(Color.valueOf("#5f98c3")),
    EPIC(Color.valueOf("#b792c8")),
    LEGENDARY(Color.valueOf("#e5ad4d")),
    EXOTIC(Color.valueOf("#d95955"));

    @Getter
    private final Color color;

    TacticAndFlagAndPetRarity(Color color) {
        this.color = color;
    }
}
