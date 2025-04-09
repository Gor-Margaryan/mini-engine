package com.bootcamp.demo.pages;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.pages.core.APage;

public class TestPage extends APage {
    @Override
    protected void constructContent(Table content) {

        Table uiSegment = new Table();
        uiSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#fefae0")));


        Table gameSegment = new Table();
        gameSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#dda15e")));
        Table game1 = new Table();
        game1.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ccc5b9")));
        gameSegment.add(game1).expand().bottom().width(700).height(120);


        Table statsSegment = constructStatsSegment();
        Table buttonSegment = constructButtonSegment();
        Table equipSegment = constructEquipSegment();
        uiSegment.add(statsSegment).expand().top().fillX().height(305).pad(15);
        uiSegment.row();
        uiSegment.add(equipSegment).expand().fill().pad(15);
        uiSegment.row();
        uiSegment.add(buttonSegment).expand().bottom().fillX().height(295).pad(15);



        //     Table statsSegment = constructStatsSegment();
        //     Table buttonSegment = constructButtonSegment();
        //     Table equipSegment = constructEquipSegment();


        //     uiSegment.add(statsSegment).expand().top().growX().height(360).pad(30);
        //     uiSegment.row();
        //     uiSegment.add(equipSegment).expand().center().growX().height(510).pad(30);
        //     uiSegment.row();
        //     uiSegment.add(buttonSegment).expand().bottom().growX().height(260).pad(30);


        content.add(gameSegment).expand().fill();
        content.row();
        content.add(uiSegment).expand().fill().height(getHeight()-100);


    }



    public Table constructStatsSegment() {
        Table statsSegment = new Table();
        statsSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ccc5b9")));

        Table stats1 = new Table();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Table statsCell = new Table();
                statsCell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#414833")));
                stats1.add(statsCell).expand();
            }
            stats1.row();
        }
        statsSegment.add(stats1).expand().fill().pad(20);


        Table stats2 = new Table();
        Table stats2Cell = new Table();
        stats2Cell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#fefae0")));
        stats2.add(stats2Cell).size(150);
        statsSegment.add(stats2).right().width(250);

        return statsSegment;
    }

    public Table constructEquipSegment() {
        Table equip = new Table();
        Table equip1 = new Table();
        equip1.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ccc5b9")));




        equip.add(equip1)
            .expand()
            .left()
            .height(420)
            .growX()
            .space(15)
            .pad(30);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                Table equip1_cell = new Table();
                equip1_cell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#deab90")));
                equip1.add(equip1_cell)
                    .expand()
                    .height(190)
                    .width(190);
            }
            equip1.row();
        }

        Table equip2 = new Table();
        equip.add(equip2)
            .right()
            .height(540)
            .width(560);


        for (int j = 0; j < 2; j++) {
            Table equip2_cell = new Table();
            equip2_cell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#deab90")));
            equip2.add(equip2_cell)
                .expand()
                .grow()
                .pad(35);

            if (j == 0) {
                equip2_cell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#fefae0")));

                for (int k = 0; k < 2; k++) {
                    Table equip2_cell_of_cell = new Table();
                    equip2_cell_of_cell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#deab90")));
                    equip2_cell.add(equip2_cell_of_cell)
                        .expand()
                        .grow()
                        .pad(15);

                    equip2_cell.row();
                    if (k == 0) {
                    Table mek = new Table();           // senc em grel vorovhetev for-ov grum ei stackoverflow er qcum
                    mek.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ced4da")));
                    Table erku = new Table();         // senc em grel vorovhetev for-ov grum ei stackoverflow er qcum
                        erku.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ced4da")));
                    Table ereq = new Table();        // senc em grel vorovhetev for-ov grum ei stackoverflow er qcum
                        ereq.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ced4da")));
                    Table chors = new Table();       // senc em grel vorovhetev for-ov grum ei stackoverflow er qcum
                        chors.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ced4da")));
                    equip2_cell_of_cell.add(mek).expand().grow().pad(5);    // senc em grel vorovhetev for-ov grum ei stackoverflow er qcum
                    equip2_cell_of_cell.add(erku).expand().grow().pad(5);   // senc em grel vorovhetev for-ov grum ei stackoverflow er qcum
                    equip2_cell_of_cell.row();
                    equip2_cell_of_cell.add(ereq).expand().grow().pad(5);   // senc em grel vorovhetev for-ov grum ei stackoverflow er qcum
                    equip2_cell_of_cell.add(chors).expand().grow().pad(5);} // senc em grel vorovhetev for-ov grum ei stackoverflow er qcum

                }
            }
            if (j == 1) {
                Table xxx = new Table();
                xxx.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#dda15e")));
                equip2_cell.add(xxx).expand().bottom().fillX().height(130);
            }


        }


        return equip;
    }

    public Table constructButtonSegment() {
        Table buttonSegment = new Table();

        for (int i = 0; i < 3; i++) {
            Table buttonCell = new Table();
            buttonCell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#dda15e")));
            buttonSegment.add(buttonCell)
                .expand()
                .fillX()
                .height(140)
                .pad(15);

            if (i == 1) {
                buttonCell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#09F162")));
            }
            if (i == 2) {
                buttonCell.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#ccc5b9")));
            }

        }

        return buttonSegment;
    }


}
