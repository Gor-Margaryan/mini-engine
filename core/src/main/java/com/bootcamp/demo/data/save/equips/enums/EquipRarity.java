package com.bootcamp.demo.data.save.equips.enums;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;

public enum EquipRarity {
    RUSTED(1, Color.valueOf("#b29985")), RUSTED_2(2, Color.valueOf("#b29985")),
    SCRAP(1, Color.valueOf("#5f98c3")), SCRAP_2(2, Color.valueOf("#5f98c3")),
    HARDENED(1, Color.valueOf("#b792c8")), HARDENED_2(2, Color.valueOf("#b792c8")),
    ELITE(1, Color.valueOf("#e5ad4d")), ELITE_2(2, Color.valueOf("#e5ad4d")),
    ASCENDANT(1, Color.valueOf("#d95955")),ASCENDANT_2(2, Color.valueOf("#d95955")),
    NUCLEAR(1, Color.valueOf("#a7d434")),
    JUGGERNAUT(1, Color.valueOf("#796deb")),
    DOMINION(1, Color.valueOf("#fb647d")),
    OBLIVION(1, Color.valueOf("#4effba")),
    IMMORTAL(1, Color.valueOf("#68ffdd")),
    ETHEREAL(1, Color.valueOf("#fffcd1"));


    @Getter
    private final int starCount;
    @Getter
    private final Color color;


    EquipRarity(int starCount, Color color) {
        this.starCount = starCount;
        this.color = color;
    }
}
