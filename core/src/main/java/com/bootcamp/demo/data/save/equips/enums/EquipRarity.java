package com.bootcamp.demo.data.save.equips.enums;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;

public enum EquipRarity {
    RUSTED(1, Color.valueOf("#d4a373")), RUSTED_2(2, Color.valueOf("#d4a373")),
    SCRAP(1, Color.valueOf("#00b4d8")), SCRAP_2(2, Color.valueOf("#00b4d8")),
    HARDENED(1, Color.valueOf("#ff99c8")), HARDENED_2(2, Color.valueOf("#ff99c8")),
    ELITE(1, Color.valueOf("#ffbe0b")), ELITE_2(2, Color.valueOf("#ffbe0b")),
    ASCENDANT(1, Color.valueOf("#ef233c")),ASCENDANT_2(2, Color.valueOf("#ef233c")),
    NUCLEAR(1, Color.valueOf("#9ef01a")),
    JUGGERNAUT(1, Color.valueOf("#3c096c")),
    DOMINION(1, Color.valueOf("#ff3c38")),
    OBLIVION(1, Color.valueOf("#7ae582")),
    IMMORTAL(1, Color.valueOf("#59d2fe")),
    ETHEREAL(1, Color.valueOf("#ffee70"));


    @Getter
    private final int starCount;
    @Getter
    private final Color color;


    EquipRarity(int starCount, Color color) {
        this.starCount = starCount;
        this.color = color;
    }
}
