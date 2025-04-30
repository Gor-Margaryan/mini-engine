package com.bootcamp.demo.pages.my.containers;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.save.SaveData;
import com.bootcamp.demo.data.save.stats.StatsManager;
import com.bootcamp.demo.data.save.stats.enums.Stat;
import com.bootcamp.demo.engine.widgets.WidgetsContainer;
import com.bootcamp.demo.pages.my.widgets.StatWidget;

public class StatsContainer extends WidgetsContainer<StatWidget> {
    public StatsContainer() {
        super(3);
        defaults()
            .size(440, 60)
            .space(30);
        for (int i = 0; i < 9; i++) {
            StatWidget statWidget = new StatWidget();
            add(statWidget);
        }
    }

    public void setData(@Null SaveData saveData) {
        ObjectMap<Stat, Float> allStats = StatsManager.getAllStats(saveData);
        Array<StatWidget> widgets = getWidgets();
        for (ObjectMap.Entry<Stat, Float> entry : allStats.entries()) {
            int i = 0;

            if (entry.key == Stat.ATK) {
                i = 1;
            }
            if (entry.key == Stat.DODGE) {
                i = 2;
            }
            if (entry.key == Stat.COMBO) {
                i = 3;
            }
            if (entry.key == Stat.CRIT) {
                i = 4;
            }
            if (entry.key == Stat.STUN) {
                i = 5;
            }
            if (entry.key == Stat.REGEN) {
                i = 6;
            }
            if (entry.key == Stat.STEAL) {
                i = 7;
            }
            if (entry.key == Stat.POISON) {
                i = 8;
            }
            widgets.get(i).setData(entry);
        }

    }
}
