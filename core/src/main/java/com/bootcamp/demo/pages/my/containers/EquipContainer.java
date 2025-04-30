package com.bootcamp.demo.pages.my.containers;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.game.equips.enums.EquipType;
import com.bootcamp.demo.data.save.equips.EquipSaveData;
import com.bootcamp.demo.data.save.equips.EquipsSaveData;
import com.bootcamp.demo.engine.widgets.WidgetsContainer;
import com.bootcamp.demo.pages.my.widgets.EquipWidget;

public class EquipContainer extends WidgetsContainer<EquipWidget> {
    public EquipContainer() {
        super(3);
        defaults()
            .size(275)
            .space(30);
        for (int i = 0; i < 6; i++) {
            EquipWidget equipWidget = new EquipWidget(i);
            add(equipWidget);
        }

    }

    public void setData(@Null EquipsSaveData equipsSaveData) {
        Array<EquipWidget> widgets = getWidgets();
        ObjectMap<EquipType, EquipSaveData> equips = equipsSaveData.getEquips();

        for (ObjectMap.Entry<EquipType, EquipSaveData> entry : equips.entries()) {
            int i = 0;
            if (entry.key == EquipType.MELEE) {
                i = 1;
            }
            if (entry.key == EquipType.HEAD) {
                i = 2;
            }
            if (entry.key == EquipType.BODY) {
                i = 3;
            }
            if (entry.key == EquipType.GLOVES) {
                i = 4;
            }
            if (entry.key == EquipType.SHOES) {
                i = 5;
            }
            widgets.get(i).setData(entry.value);
        }

    }
}


