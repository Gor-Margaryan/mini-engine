package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Null;
import com.bootcamp.demo.data.game.GameData;
import com.bootcamp.demo.data.game.tactics.TacticGameData;
import com.bootcamp.demo.data.save.tactics.TacticSaveData;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;
import com.bootcamp.demo.managers.API;

public class TacticWidget extends BorderedTable {
    private final Image image;

    public TacticWidget() {
        image = new Image();
        setBackground(Squircle.SQUIRCLE_50.getDrawable(Color.valueOf("#81776e")));
        add(image).size(90,70);
    }

    public void setData(@Null TacticSaveData tacticSaveData) {
        if (tacticSaveData != null) {
        final TacticGameData tacticGameData = API.get(GameData.class).getTacticsGameData().getTactics().get(tacticSaveData.getName());
        image.setDrawable(tacticGameData.getDrawable());
        setBackground(Squircle.SQUIRCLE_50.getDrawable(tacticGameData.getTacticRarity().getColor()));
    }
    }
}
