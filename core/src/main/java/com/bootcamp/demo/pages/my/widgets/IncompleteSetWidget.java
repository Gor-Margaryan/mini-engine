package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Labels;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;
import com.bootcamp.demo.localization.GameFont;

public class IncompleteSetWidget extends Table {
    private final Label label;
    private final BorderedTable borderedTable;
    private final Image image;

    public IncompleteSetWidget() {
        label = Labels.make(GameFont.BOLD_24, Color.valueOf("#212529"), "Incomplete Set");
        image = new Image(new Texture("incomplete.png"));

        borderedTable = new BorderedTable();
        borderedTable.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#f5e9dc")));
        borderedTable.add(image).size(70);

        setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#a9a29c")));
        add(label).expand().center();
        add(borderedTable).padRight(-50);

    }
}
