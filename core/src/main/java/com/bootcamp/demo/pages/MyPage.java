package com.bootcamp.demo.pages;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.data.save.SaveData;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;
import com.bootcamp.demo.managers.API;
import com.bootcamp.demo.pages.my.containers.EquipContainer;
import com.bootcamp.demo.pages.my.containers.StatsContainer;
import com.bootcamp.demo.pages.core.APage;
import com.bootcamp.demo.pages.my.containers.TacticsContainer;
import com.bootcamp.demo.pages.my.widgets.*;

public class MyPage extends APage {
    private static PowerWidget powerWidget;
    private static StatsContainer statsContainer;
    private static EquipContainer equipContainer;
    private static TacticsContainer tacticsContainer;
    private static FlagWidget flagWidget;
    private static PetWidget petWidget;

    @Override
    protected void constructContent(Table content) {
        final Table powerSegment = constructPowerSegment();
        final Table statsSegment = constructStatsSegment();
        final Table equipSegment = constructEquipSegment();
        final Table buttonSegment = constructButtonSegment();


        final Table uiSegment = new Table();
        uiSegment.defaults().pad(20);
        uiSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#f4eae1")));
        uiSegment.add(powerSegment).padTop(-140);
        uiSegment.row();
        uiSegment.add(statsSegment);
        uiSegment.row();
        uiSegment.add(equipSegment);
        uiSegment.row();
        uiSegment.add(buttonSegment);

        content.add(uiSegment).expand().bottom();
    }


    public Table constructPowerSegment() {

        powerWidget = new PowerWidget();

        final Table powerTable = new Table();
        powerTable.setBackground(Squircle.SQUIRCLE_35_TOP.getDrawable(Color.WHITE));
        powerTable.add(powerWidget).size(600, 125).pad(15);
        return powerTable;
    }

    public Table constructStatsSegment() {
        statsContainer = new StatsContainer();

        final BorderedTable statsButton = new BorderedTable();
        statsButton.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#f4eae2")));
        statsButton.add(new Image(new Texture("menu.png"))).size(80, 66);

        final Table statsSegment = new Table();
        statsSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#b6a89b")));
        statsSegment.defaults().pad(20);
        statsSegment.add(statsContainer);
        statsSegment.add(statsButton).size(118, 130);


        return statsSegment;
    }

    public Table constructEquipSegment() {
        final FirstEquipTable firstEquipTable = new FirstEquipTable();
        final SecondaryEquipTable secondaryEquipTable = new SecondaryEquipTable();

        final Table equipSegment = new Table();
        equipSegment.defaults().space(50);
        equipSegment.add(firstEquipTable);
        equipSegment.add(secondaryEquipTable);

        return equipSegment;
    }

    public Table constructButtonSegment() {
        final LootUpgradeButton lootUpgradeButton = new LootUpgradeButton();

        final LootButton lootButton = new LootButton();

        final AutoLootButton autoLootButton = new AutoLootButton();


        final Table buttonSegment = new Table();
        buttonSegment.defaults().space(80).size(465, 190);
        buttonSegment.add(lootUpgradeButton);
        buttonSegment.add(lootButton);
        buttonSegment.add(autoLootButton);

        return buttonSegment;
    }


    public static class FirstEquipTable extends Table {
        private final IncompleteSetWidget incompleteSetTable;

        public FirstEquipTable() {
            incompleteSetTable = new IncompleteSetWidget();
            equipContainer = new EquipContainer();


            setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#d2cfcc")));
            add(incompleteSetTable).size(870, 70).pad(20);
            row();
            add(equipContainer).padRight(25).padLeft(25).padBottom(20);

        }
    }

    public static class SecondaryEquipTable extends Table {

        private final TacticsAndFlag tacticsAndFlag;

        public SecondaryEquipTable() {

            tacticsAndFlag = new TacticsAndFlag();
            petWidget = new PetWidget();

            defaults()
                .space(40)
                .size(270, 580);
            add(tacticsAndFlag);
            add(petWidget);

        }
    }

    public static class TacticsAndFlag extends Table {

        public TacticsAndFlag() {
            tacticsContainer = new TacticsContainer();
            flagWidget = new FlagWidget();


            defaults()
                .size(270)
                .space(40);

            add(tacticsContainer);
            row();
            add(flagWidget);
        }

    }




    @Override
    public void show(Runnable onComplete) {
        super.show(onComplete);
        powerWidget.setData(API.get(SaveData.class));
        statsContainer.setData(API.get(SaveData.class));
        equipContainer.setData(API.get(SaveData.class).getEquipsSaveData());
        tacticsContainer.setData(API.get(SaveData.class).getEquippedTacticsSaveData());
        flagWidget.setData(API.get(SaveData.class));
        petWidget.setData(API.get(SaveData.class));
        if (API.get(SaveData.class).getEquippedPetSaveData().getName() != null) {
            petWidget.animate();
        }
    }
}
