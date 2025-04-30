package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.save.stats.enums.Stat;
import com.bootcamp.demo.data.save.stats.enums.StatType;
import com.bootcamp.demo.engine.Labels;
import com.bootcamp.demo.localization.GameFont;

public class StatWidget extends Table {
    private final Label statType;
    private final Label stats;

    public StatWidget() {
        statType = Labels.make(GameFont.BOLD_24, Color.valueOf("#212529"));
        stats = Labels.make(GameFont.BOLD_24, Color.WHITE);


        defaults().space(140);
        add(statType).expand().left();
        add(stats).expand().right();
    }

    public void setData (@Null ObjectMap.Entry<Stat, Float> stat) {
        statType.setText(stat.key + ":");
        if (stat.key.getStatType() == StatType.MULTIPLICATIVE)
            stats.setText((Math.round(stat.value * 100)/100f) + "%");
        else {
            stats.setText((Math.round(stat.value * 100)/100f) + "K");
    }
    }
}
