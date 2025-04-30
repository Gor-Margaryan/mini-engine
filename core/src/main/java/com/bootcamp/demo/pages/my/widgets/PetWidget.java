package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;
import com.bootcamp.demo.engine.widgets.OffsetButton;

public class PetWidget extends BorderedTable {
    private final Image homeImage;
    private final Image petImage;

    private final OffsetButton homeButton;
    private final Table petTable;

    public PetWidget() {
        homeImage = new Image(new Texture("home.png"));
        petImage = new Image(new Texture("bones.png"));

        homeButton = new OffsetButton(OffsetButton.Style.YELLOW_35);
        homeButton.getFrontTable().add(homeImage);

        petTable = new Table();
        petTable.add(petImage).size(160);

        add(petTable).expand().bottom().space(50);
        row();
        add(homeButton).size(268, 160).bottom().padBottom(-8);

        setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#c9c0b9")));
    }
}
