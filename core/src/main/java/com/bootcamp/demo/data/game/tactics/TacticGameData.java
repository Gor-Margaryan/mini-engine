package com.bootcamp.demo.data.game.tactics;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.XmlReader;
import com.bootcamp.demo.data.game.IGameData;
import com.bootcamp.demo.data.game.tactics.enums.TacticAndFlagAndPetRarity;
import com.bootcamp.demo.engine.Resources;
import lombok.Getter;

import java.util.Locale;

public class TacticGameData implements IGameData {
    @Getter
    private String name;
    @Getter
    private Drawable drawable;
    @Getter
    private float HP;
    @Getter
    private float ATK;
    @Getter
    private int starCount;
    @Getter
    private TacticAndFlagAndPetRarity tacticRarity;



    @Override
    public void load(XmlReader.Element rootXml) {
        name = rootXml.getAttribute("name");
        drawable = Resources.getDrawable(rootXml.getAttribute("icon"));
        HP = rootXml.getFloat("hp");
        ATK = rootXml.getFloat("atk");
        starCount = rootXml.getInt("starCount");
        tacticRarity = TacticAndFlagAndPetRarity.valueOf(rootXml.getAttribute("rarity").toUpperCase(Locale.ENGLISH));

    }
}
