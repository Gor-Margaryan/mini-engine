package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.game.GameData;
import com.bootcamp.demo.data.game.equips.EquipGameData;
import com.bootcamp.demo.data.game.equips.EquipsGameData;
import com.bootcamp.demo.data.save.equips.EquipSaveData;
import com.bootcamp.demo.engine.Labels;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;
import com.bootcamp.demo.localization.GameFont;
import com.bootcamp.demo.managers.API;

public class EquipWidget extends BorderedTable {
    private final Image firstStarImage = new Image();
    private final Image secondStarImage = new Image();
    private final Image itemImage = new Image();

    private final Label levelLabel;

    private final Table starLayer;
    private final Table levelLayer;

    public EquipWidget(int i) {
        levelLabel = Labels.make(GameFont.BOLD_24, Color.BLACK);

        starLayer = new Table();
        starLayer.add(firstStarImage).size(45);
        starLayer.add(secondStarImage).size(45);

        levelLayer = new Table();
        levelLayer.add(levelLabel);

        if (i == 0) {
            itemImage.setDrawable(new TextureRegionDrawable(new Texture("gun.png")));
        }
        if (i == 1) {
            itemImage.setDrawable(new TextureRegionDrawable(new Texture("knife.png")));
        }
        if (i == 2) {
            itemImage.setDrawable(new TextureRegionDrawable(new Texture("cap.png")));
        }
        if (i == 3) {
            itemImage.setDrawable(new TextureRegionDrawable(new Texture("t-shirt.png")));
        }
        if (i == 4) {
            itemImage.setDrawable(new TextureRegionDrawable(new Texture("hand.png")));
        }
        if (i == 5) {
            itemImage.setDrawable(new TextureRegionDrawable(new Texture("boots.png")));
        }


        setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#c9c0b9")));
        add(starLayer).expand().left().padLeft(10).padTop(10);
        row();
        add(itemImage).size(160);
        row();
        add(levelLayer).expand().left().padLeft(10).padBottom(10);
    }

    public void setData(@Null EquipSaveData equipSaveData) {
        if (equipSaveData == null) {
            setEmpty();
        } else {
            final EquipsGameData equipsGameData = API.get(GameData.class).getEquipsGameData();
            final ObjectMap<String, EquipGameData> equips = equipsGameData.getEquips();
            final EquipGameData equipGameData = equips.get(equipSaveData.getName());
            setBackground(Squircle.SQUIRCLE_35.getDrawable(equipSaveData.getEquipRarity().getColor()));
            firstStarImage.setDrawable(new TextureRegionDrawable(new Texture("star.png")));
            if (equipSaveData.getEquipRarity().getStarCount() == 2) {
                secondStarImage.setDrawable(new TextureRegionDrawable(new Texture("star.png")));
            }
            levelLabel.setText("Lv." + equipSaveData.getLevel());
            itemImage.setDrawable(equipGameData.getIcon());
        }

    }

    public void setEmpty() {

        firstStarImage.setDrawable(null);
        secondStarImage.setDrawable(null);
    }

}

