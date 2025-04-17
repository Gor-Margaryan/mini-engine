package com.bootcamp.demo.pages;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Labels;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.engine.widgets.BorderedTable;
import com.bootcamp.demo.engine.widgets.WidgetsContainer;
import com.bootcamp.demo.localization.GameFont;
import com.bootcamp.demo.pages.core.APage;

public class MyPage extends APage {
    @Override
    protected void constructContent(Table content) {
       final Table statsSegment = constructStatsSegment();
       final Table equipSegment = constructEquipSegment();
       final Table buttonSegment = constructButtonSegment();


        final Table uiSegment = new Table();
        uiSegment.defaults().pad(20);
        uiSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.WHITE));
        uiSegment.add(statsSegment);
        uiSegment.row();
        uiSegment.add(equipSegment);
        uiSegment.row();
        uiSegment.add(buttonSegment);

        content.add(uiSegment).expand().bottom();
    }


    public Table constructStatsSegment() {
        final StatsContainer statsContainer = new StatsContainer();

        final BorderedTable statsButton = new BorderedTable();
        statsButton.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#fff1e6")));
        statsButton.add(new Image(new Texture("menu.png")));

        Table statsSegment = new Table();
        statsSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#a5a58d")));
        statsSegment.defaults().pad(20);
        statsSegment.add(statsContainer);
        statsSegment.add(statsButton).size(190);


        return statsSegment;
    }

    public Table constructEquipSegment() {
        final EquipContainer equipContainer = new EquipContainer();
        final ItemsTable itemsTable = new ItemsTable();

        final Table equipSegment = new Table();
        equipSegment.defaults().space(20);
        equipSegment.add(equipContainer);
        equipSegment.add(itemsTable);

        return equipSegment;
    }

    public Table constructButtonSegment() {
        final BorderedTable firstButton = new BorderedTable();
        firstButton.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#f6bd60")));
        firstButton.add(new Image(new Texture("a.png"))).size(150,150).space(20);
        firstButton.add(Labels.make(GameFont.BOLD_28,Color.WHITE,"Lv.1"));

        final BorderedTable secondButton = new BorderedTable();
        secondButton.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#9ef01a")));
        secondButton.add(Labels.make(GameFont.BOLD_28,Color.WHITE,"LOOT")).space(20);
        secondButton.add(new Image(new Texture("b.png"))).size(150,150);

        final BorderedTable thirdButton = new BorderedTable();
        thirdButton.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#a5a58d")));
        thirdButton.add(Labels.make(GameFont.BOLD_28,Color.WHITE,"Auto L")).space(20);
        thirdButton.add(new Image(new Texture("c.png"))).size(150,150);


        final Table buttonSegment = new Table();
        buttonSegment.defaults().space(80).size(420,160);
        buttonSegment.add(firstButton);
        buttonSegment.add(secondButton);
        buttonSegment.add(thirdButton);

        return buttonSegment;
    }

    public static class StatWidget extends Table {
        public StatWidget() {
            defaults().space(60);
            add(Labels.make(GameFont.BOLD_28,Color.BLACK,"HP"));
            add(Labels.make(GameFont.BOLD_28,Color.BLACK,"0%"));
        }
    }

    public static class StatsContainer extends WidgetsContainer<StatWidget> {
        public StatsContainer() {
            super(3);
            defaults()
                .size(370,70)
                .space(20);
            for (int i = 0; i < 9; i++) {
                add(new StatWidget());
            }
        }

        public void setData(){

        }
    }

    public static class EquipWidget extends BorderedTable {
        public EquipWidget() {
            setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#a5a58d")));
            add(new Image(new Texture("star.png"))).size(60).expand().top().left();
            add(new Image(new Texture("minecraft.png"))).size(200);

        }
    }

    public static class EquipContainer extends WidgetsContainer<EquipWidget> {
        public EquipContainer() {
            super(3);
            setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#d8e2dc")));
            defaults()
                .size(260)
                .space(10)
                .pad(10);
            for (int i = 0; i < 6; i++) {
                add(new EquipWidget());
            }

        }
    }

    public static class ItemsTable extends Table {
        public ItemsTable() {
            final SlotItems slotItems = new SlotItems();
            final HomeButton homeButton = new HomeButton();


            defaults()
                .pad(10)
                .size(260,560);
            add(slotItems);
            add(homeButton);

        }
    }

    public static class SlotItems extends Table {
        public SlotItems() {
            final ItemsContainer itemsContainer = new ItemsContainer();
            final FlagTable flagItem = new FlagTable();


            defaults()
                .grow()
                .space(20);

            add(itemsContainer);
            row();
            add(flagItem);
        }
    }

    public static class ItemsWidget extends BorderedTable {
        public ItemsWidget() {
            setBackground(Squircle.SQUIRCLE_8.getDrawable(Color.valueOf("#6b705c")));
        }
    }

    public static class ItemsContainer extends WidgetsContainer<ItemsWidget> {
        public ItemsContainer() {
            super(2);
            defaults()
                .grow()
                .pad(15);
            for (int i = 0; i < 4; i++) {
                add(new ItemsWidget());
            }
            setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#b7b7a4")));

        }
    }

    public static class FlagTable extends BorderedTable {
        public FlagTable() {
            setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#b7b7a4")));
            add(new Image(new Texture("flag.png"))).size(100);
        }
    }

    public static class HomeButton extends BorderedTable{

        public HomeButton() {
            final BorderedTable button = new BorderedTable();
            button.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#f6bd60")));
            button.add(new Image(new Texture("home.png"))).size(200);

            add(new Image(new Texture("kriper.png"))).size(200,280).expand().bottom();
            row();
            add(button).expand().size(260,160).bottom();

            setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.valueOf("#b7b7a4")));
        }
    }

}
