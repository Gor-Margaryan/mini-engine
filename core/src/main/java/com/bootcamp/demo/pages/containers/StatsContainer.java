package com.bootcamp.demo.pages.containers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;

public class StatsContainer extends Table {

    public StatsContainer() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Table statsCell = new Table();
                statsCell.setBackground(Squircle.SQUIRCLE_35_BORDER.getDrawable(Color.WHITE));
                this.add(statsCell).expand().fillX().space(5);
            }
            this.row();
        }
    }

}
