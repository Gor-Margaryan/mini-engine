package com.bootcamp.demo.data.game.equips;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.XmlReader;
import com.bootcamp.demo.data.game.IGameData;
import com.bootcamp.demo.data.game.equips.enums.EquipType;
import com.bootcamp.demo.engine.Resources;
import lombok.Getter;

import java.util.Locale;

public class EquipGameData implements IGameData {
    @Getter
    private String name;
    @Getter
    private EquipType equipType;
    @Getter
    private Drawable icon;

    @Override
    public void load(XmlReader.Element rootXml) {
        name = rootXml.getAttribute("name");
        equipType = EquipType.valueOf(rootXml.getAttribute("equipType").toUpperCase(Locale.ENGLISH));
        icon = Resources.getDrawable(rootXml.getAttribute("icon"));
    }
}
