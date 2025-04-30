package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.bootcamp.demo.engine.Labels;
import com.bootcamp.demo.engine.widgets.OffsetButton;
import com.bootcamp.demo.localization.GameFont;

public class LootButton extends OffsetButton {
    private final Image image;
    private final Label label;

    public LootButton() {
        super(Style.GREEN_35);
        image = new Image(new Texture("loot.png"));
        label = Labels.make(GameFont.BOLD_28, Color.WHITE, "LOOT");

        getFrontTable().add(label).space(20);
        getFrontTable().add(image);
    }
}
