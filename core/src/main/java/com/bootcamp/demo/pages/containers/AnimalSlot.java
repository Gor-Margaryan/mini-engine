package com.bootcamp.demo.pages.containers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;

public class AnimalSlot extends Table {
    public AnimalSlot() {

        this.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#b7b7a4")));

        Table animalButton = new Table();
        animalButton.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#fcbf49")));

        this.add(animalButton).expand().bottom().fillX().height(120);
    }
}
