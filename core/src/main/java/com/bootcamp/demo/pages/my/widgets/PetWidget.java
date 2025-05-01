package com.bootcamp.demo.pages.my.widgets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Null;
import com.bootcamp.demo.data.game.GameData;
import com.bootcamp.demo.data.game.pets.PetGameData;
import com.bootcamp.demo.data.save.SaveData;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;
import com.bootcamp.demo.engine.widgets.OffsetButton;
import com.bootcamp.demo.managers.API;

public class PetWidget extends BorderedTable {
    private final Image homeImage;
    private final Image petImage;
    private final Image firstStarImage;
    private final Image secondStarImage;

    private final OffsetButton homeButton;
    private final Table petTable;
    private final Table starLayer;

    public PetWidget() {
        homeImage = new Image(new Texture("home.png"));
        petImage = new Image(new Texture("bones.png"));
        firstStarImage = new Image();
        secondStarImage = new Image();

        homeButton = new OffsetButton(OffsetButton.Style.YELLOW_35);
        homeButton.getFrontTable().add(homeImage);

        starLayer = new Table();
        starLayer.add(firstStarImage).size(45);
        starLayer.add(secondStarImage).size(45);


        petTable = new Table();
        petTable.add(petImage).size(160);


        add(starLayer).top().left().padLeft(20).padTop(15);
        row();
        add(petTable).expand().bottom().space(50);
        row();
        add(homeButton).size(268, 160).bottom().padBottom(-8);

        setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#c9c0b9")));
    }
    public void setData (@Null SaveData saveData) {
        String name = saveData.getEquippedPetSaveData().getName();
        if (name != null) {
            PetGameData petGameData = API.get(GameData.class).getPetsGameData().getPets().get(name);
            setBackground(Squircle.SQUIRCLE_35.getDrawable(petGameData.getTacticAndFlagAndPetRarity().getColor()));
            firstStarImage.setDrawable(new TextureRegionDrawable(new Texture("star.png")));
            if (petGameData.getTacticAndFlagAndPetRarity().getStarCount() == 2){
                secondStarImage.setDrawable(new TextureRegionDrawable(new Texture("star.png")));
            }
            petImage.setDrawable(petGameData.getDrawable());
        }
    }

    public void animate () {
            Gdx.app.postRunnable(() -> {
                petTable.setTransform(true);
                petTable.clearActions();
                petTable.setOrigin(Align.center);

                petTable.addAction(
                    Actions.forever(
                        Actions.sequence(
                            Actions.moveBy(0, 10,  0.14f, Interpolation.sine),
                            Actions.moveBy(10, 0,  0.14f, Interpolation.sine),
                            Actions.moveBy(0, -10, 0.14f, Interpolation.sine),
                            Actions.moveBy(-10, 0, 0.14f, Interpolation.sine)
                        )
                        ) );

            });


   }
}
