package com.bootcamp.demo.pages;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.pages.containers.CommonEquipContainer;
import com.bootcamp.demo.pages.containers.EquipGearContainer;
import com.bootcamp.demo.pages.containers.StatsContainer;
import com.bootcamp.demo.pages.core.APage;

public class MyPage extends APage {
    @Override
    protected void constructContent(Table content) {
        Table uiSegment = new Table();
        uiSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.WHITE));

        Table statsSegment = constructStatsSegment();
        uiSegment.add(statsSegment).expand().top().fillX().height(300).pad(10);

        uiSegment.row();

        Table equipSegment = constructEquipSegment();
        uiSegment.add(equipSegment).expand().fill().pad(10);


        uiSegment.row();

        Table buttonSegment = constructButtonSegment();
        uiSegment.add(buttonSegment).expand().bottom().fillX().height(250).pad(10);


        content.add(uiSegment).expand().bottom().fillX().height(1200);
    }


    public Table constructStatsSegment(){

        Table statsTable = new Table();
        statsTable.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#b7b7a4")));

        StatsContainer statsContainer = new StatsContainer();
        statsTable.add(statsContainer).expand().fill().pad(30);

        Table statsButton = new Table();
        statsButton.setBackground(Squircle.SQUIRCLE_35_BORDER.getDrawable(Color.valueOf("#cb997e")));

        statsTable.add(statsButton).width(150).height(150).pad(30);

        return statsTable;
    }

    public Table constructEquipSegment(){
        Table equipTable = new Table();

        EquipGearContainer equipGearContainer = new EquipGearContainer();
        equipTable.add(equipGearContainer).expand().fill().pad(30);

        CommonEquipContainer commonEquipContainer = new CommonEquipContainer();
        equipTable.add(commonEquipContainer).width(480).expandY().fillY().pad(30);
        commonEquipContainer.debug();

        return equipTable;
    }

    public Table constructButtonSegment(){

        Table buttonTable = new Table();

        for (int i = 0; i < 3; i++) {

            Table buttonCell = new Table();

            if (i == 0) {
                buttonCell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#dda15e")));
            }
            if (i == 1) {
                buttonCell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#09F162")));
            }
            if (i == 2) {
                buttonCell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ccc5b9")));
            }

            buttonTable.add(buttonCell).expand().fill().pad(30);
        }
        return buttonTable;
    }



}
