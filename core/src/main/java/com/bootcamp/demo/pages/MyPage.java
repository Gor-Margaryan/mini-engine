package com.bootcamp.demo.pages;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.bootcamp.demo.engine.Squircle;
import com.bootcamp.demo.pages.core.APage;

public class MyPage extends APage {
    @Override
    protected void constructContent(Table content) {
        Table uiSegment = new Table();
        uiSegment.setBackground(Squircle.SQUIRCLE_35.getDrawable(Color.WHITE));





        content.add(uiSegment).expand().bottom().fillX().height(1200);
    }


    public Table constructStatsTable(){

    }



}
