package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;

public class TacticWidget extends BorderedTable {
    public TacticWidget() {
        setBackground(Squircle.SQUIRCLE_50.getDrawable(Color.valueOf("#81776e")));
    }
}
