package com.bootcamp.demo.pages.my.containers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.save.tactics.TacticSaveData;
import com.bootcamp.demo.data.save.tactics.TacticsSaveData;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.WidgetsContainer;
import com.bootcamp.demo.pages.my.widgets.TacticWidget;

public class TacticsContainer extends WidgetsContainer<TacticWidget> {
    public TacticsContainer() {
        super(2);
        defaults()
            .expand()
            .pad(10);
        for (int i = 0; i < 4; i++) {
            add(new TacticWidget());
        }
        setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#c9c0b9")));

    }

    public void setData(@Null TacticsSaveData tacticsSaveData) {
        ObjectMap<String, TacticSaveData> tactics = tacticsSaveData.getTactics();
        Array<TacticWidget> widgets = getWidgets();
        int i = 0;
        for (ObjectMap.Entry<String, TacticSaveData> entry : tactics.entries()){
            widgets.get(i).setData(entry.value);
            if (i < 3){
                i++;
            }

        }
    }
}
