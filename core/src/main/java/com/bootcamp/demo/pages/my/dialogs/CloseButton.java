package com.bootcamp.demo.pages.my.dialogs;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.bootcamp.demo.dialogs.core.DialogManager;
import com.bootcamp.demo.engine.widgets.OffsetButton;
import com.bootcamp.demo.managers.API;


public class CloseButton extends OffsetButton {
    private final Image image;

    public CloseButton() {
        super(Style.RED_35);
        image = new Image(new Texture("close.png"));
        getFrontTable().add(image).size(90, 90);
        setOnClick(() -> {
            API.get(DialogManager.class).hide(EquipDialog.class);
        });
    }
}
