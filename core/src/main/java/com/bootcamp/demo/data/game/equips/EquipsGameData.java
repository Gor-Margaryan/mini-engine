package com.bootcamp.demo.data.game.equips;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.XmlReader;
import com.bootcamp.demo.data.game.IGameData;
import lombok.Getter;

public class EquipsGameData implements IGameData {
    @Getter
    private final ObjectMap<String,EquipGameData> equips = new ObjectMap<>();

    @Override
    public void load(XmlReader.Element rootXml) {
        equips.clear();
        final Array<XmlReader.Element> equipsXML = rootXml.getChildrenByName("equip");
        for (XmlReader.Element equipXML : equipsXML) {
            EquipGameData equipGameData = new EquipGameData();
            equipGameData.load(equipXML);
            equips.put(equipGameData.getName(), equipGameData);
        }
    }
}
