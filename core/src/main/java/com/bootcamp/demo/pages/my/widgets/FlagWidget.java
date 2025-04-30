package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;

public class FlagWidget extends BorderedTable {
    private final Image flagImage;
    private final Image starImage;
    private final Image lockImage;

    private final Table starLayer;
    private final Table lockLayer;

    public FlagWidget() {
        flagImage = new Image(new Texture("flag.png"));
        starImage = new Image();
        lockImage = new Image(new Texture("lock.png"));

        starLayer = new Table();
        starLayer.add(starImage).size(40);

        lockLayer = new Table();
        lockLayer.add(lockImage).size(50, 70);

        setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#c9c0b9")));
        add(starLayer).left().space(15).padLeft(5).padTop(5);
        row();
        add(flagImage).expand().size(140).top();
        row();
        add(lockLayer).right();

    }
}
