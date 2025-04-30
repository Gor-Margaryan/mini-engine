package com.bootcamp.demo.pages.my.containers;

import com.badlogic.gdx.graphics.Color;
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
}
