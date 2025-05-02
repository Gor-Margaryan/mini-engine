package com.bootcamp.demo.pages.my.dialogs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.bootcamp.demo.data.game.GameData;
import com.bootcamp.demo.data.game.equips.EquipGameData;
import com.bootcamp.demo.data.save.equips.EquipSaveData;
import com.bootcamp.demo.dialogs.core.ADialog;
import com.bootcamp.demo.engine.Labels;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;
import com.bootcamp.demo.localization.GameFont;
import com.bootcamp.demo.managers.API;


public class EquipDialog extends ADialog {

    private static EquipSaveData equipSaveData;

    private static EquipGameData equipGameData;

    public static void setData(EquipSaveData equipSaveData1) {
        equipSaveData = equipSaveData1;
        equipGameData = API.get(GameData.class).getEquipsGameData().getEquips().get(equipSaveData.getName());
    }

    @Override
    protected void constructTitleSegment(Table titleSegment) {
        CloseButton closeButton = new CloseButton();

        Label label = Labels.make(GameFont.BOLD_40, Color.BLACK, "Gear info");
        titleSegment.add(label).expand().pad(50);
        titleSegment.add(closeButton).padRight(50);

    }

    @Override
    protected void constructContent(Table content) {
        CommonEquipInfo commonEquipInfo = new CommonEquipInfo();

        content.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#f4eae1")));
        content.add(commonEquipInfo).pad(40);

    }

    @Override
    protected void constructDialog(Table dialog) {
        super.constructDialog(dialog);
        dialog.setColor(Color.valueOf("#f4eae1"));
    }


    private static class CommonEquipInfo extends Table {
        private final Label equipName;

        private final Table nameLayer;

        private final Equip equip;
        private final PowRarTypTable powRarTypTable;
        private final PowRarTypInfoTable powRarTypInfoTable;

        public CommonEquipInfo() {
            equipName = Labels.make(GameFont.BOLD_40, Color.BLACK, equipSaveData.getName());

            nameLayer = new Table();
            nameLayer.add(equipName).left();


            equip = new Equip();
            powRarTypTable = new PowRarTypTable();
            powRarTypInfoTable = new PowRarTypInfoTable();


            defaults().pad(40);
            setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#bfbab7")));
            add(nameLayer);
            row();
            add(equip).size(350);
            add(powRarTypTable);
            add(powRarTypInfoTable);


        }
    }

    private static class PowRarTypTable extends Table {
        private final Label power;
        private final Label rarity;
        private final Label type;

        public PowRarTypTable() {
            power = Labels.make(GameFont.BOLD_36, Color.BLACK, "Power:");
            rarity = Labels.make(GameFont.BOLD_36, Color.BLACK, "Rarity:");
            type = Labels.make(GameFont.BOLD_36, Color.BLACK, "Type:");
            defaults().space(40);
            add(power).left();
            row();
            add(rarity).left();
            row();
            add(type).left();
        }
    }

    private static class PowRarTypInfoTable extends Table {

        private final Label powerInfo;
        private final Label rarityInfo;
        private final Label typeInfo;

        public PowRarTypInfoTable() {
            float power = equipSaveData.getPower();
            power = (Math.round(power * 100) / 100f);

            powerInfo = Labels.make(GameFont.BOLD_36, Color.WHITE, power + "K");
            rarityInfo = Labels.make(GameFont.BOLD_36, equipSaveData.getEquipRarity().getColor(), equipSaveData.getEquipRarity() + "");
            typeInfo = Labels.make(GameFont.BOLD_36, Color.WHITE, equipGameData.getEquipType() + "");


            add(powerInfo).space(40).right();
            row();
            add(rarityInfo).space(40);
            row();
            add(typeInfo).space(40).right();
        }
    }

    private static class Equip extends BorderedTable {
        private final Image firstStarImage = new Image();
        private final Image secondStarImage = new Image();
        private final Image itemImage = new Image();

        private final Label levelLabel;

        private final Table starLayer;
        private final Table levelLayer;

        public Equip() {
            firstStarImage.setDrawable(new TextureRegionDrawable(new Texture("star.png")));
            if (equipSaveData.getEquipRarity().getStarCount() == 2) {
                secondStarImage.setDrawable(new TextureRegionDrawable(new Texture("star.png")));
            }

            itemImage.setDrawable(equipGameData.getIcon());
            itemImage.setScaling(Scaling.fit);

            levelLabel = Labels.make(GameFont.BOLD_32, Color.BLACK, equipSaveData.getLevel() + "");

            starLayer = new Table();
            starLayer.add(firstStarImage).size(50);
            starLayer.add(secondStarImage).size(50);

            levelLayer = new Table();
            levelLayer.add(levelLabel);

            setBackground(Squircle.SQUIRCLE_35.getDrawable(equipSaveData.getEquipRarity().getColor()));
            add(starLayer).expand().left().padLeft(10).padTop(10);
            row();
            add(itemImage);
            row();
            add(levelLayer).expand().left().padLeft(10).padBottom(10);
        }
    }


}
