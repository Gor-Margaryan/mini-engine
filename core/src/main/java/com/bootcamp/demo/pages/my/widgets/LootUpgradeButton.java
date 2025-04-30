package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Labels;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.OffsetButton;
import com.bootcamp.demo.localization.GameFont;


public class LootUpgradeButton extends OffsetButton {
    private final Image image;
    private final Label bladeLabel;
    private final Label handleLabel;
    private final Table lootLevelsTable;
    private final Table bladeLevelTable;
    private final Table handleLevelTable;

    public LootUpgradeButton() {
        super(Style.YELLOW_35);
        image = new Image(new Texture("first.png"));

        bladeLabel = Labels.make(GameFont.BOLD_20, Color.WHITE, "Lv.1");
        handleLabel = Labels.make(GameFont.BOLD_20, Color.WHITE, "Lv.1");

        bladeLevelTable = new Table();
        bladeLevelTable.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#a48d63")));
        bladeLevelTable.add(bladeLabel);

        handleLevelTable = new Table();
        handleLevelTable.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#a48d63")));
        handleLevelTable.add(handleLabel);

        lootLevelsTable = new Table();
        lootLevelsTable.defaults().size(260, 55).space(10);
        lootLevelsTable.add(bladeLevelTable);
        lootLevelsTable.row();
        lootLevelsTable.add(handleLevelTable);


        getFrontTable().add(image).space(30);
        getFrontTable().add(lootLevelsTable);

    }
}

