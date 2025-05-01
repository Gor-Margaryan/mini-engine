package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.game.equips.enums.EquipType;
import com.bootcamp.demo.data.save.SaveData;
import com.bootcamp.demo.data.save.equips.EquipSaveData;
import com.bootcamp.demo.data.save.stats.StatsManager;
import com.bootcamp.demo.data.save.stats.enums.Stat;
import com.bootcamp.demo.engine.Labels;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.localization.GameFont;

public class PowerWidget extends Table {
    final Label powerLabel = Labels.make(GameFont.BOLD_36, Color.WHITE);
    final Image image = new Image(new Texture("power.png"));

    public PowerWidget() {
        setBackground(Squircle.SQUIRCLE_35_TOP.getDrawable(Color.valueOf("#a28d7a")));
        add(image).space(30);
        add(powerLabel);
    }

    public void setData(@Null SaveData saveData) {
        float result = 0.0f;

        ObjectMap<Stat, Float> allStats = StatsManager.getAllStats(saveData);
        Float HP = allStats.get(Stat.HP);
        Float ATK = allStats.get(Stat.ATK);
        result += HP + ATK;

        ObjectMap<EquipType, EquipSaveData> equips = saveData.getEquipsSaveData().getEquips();
        for (ObjectMap.Entry<EquipType, EquipSaveData> entry : equips.entries()) {
            result += entry.value.getPower();
        }

        powerLabel.setText((Math.round(result * 100) / 100f) + "K");
    }
}
