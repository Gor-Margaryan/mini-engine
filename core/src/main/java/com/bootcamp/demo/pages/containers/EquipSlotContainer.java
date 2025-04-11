package com.bootcamp.demo.pages.containers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;

public class EquipSlotContainer extends Table {
    public EquipSlotContainer() {
        this.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#b7b7a4")));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Table item = new Table();
                item.setBackground(Squircle.SQUIRCLE_35_BORDER.getDrawable(Color.valueOf("#006d77")));
                this.add(item).expand().fill().pad(5).space(2);
            }
            this.row();
        }
    }
}
