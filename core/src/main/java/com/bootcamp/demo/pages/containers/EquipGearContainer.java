package com.bootcamp.demo.pages.containers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;

public class EquipGearContainer extends Table {
    public EquipGearContainer() {
        this.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#b7b7a4")));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                Table item = new Table();
                item.setBackground(Squircle.SQUIRCLE_35_BORDER.getDrawable(Color.BLACK));
                this.add(item).width(230).height(230).space(15).pad(8).expand();
            }
            this.row();
        }
    }
}
