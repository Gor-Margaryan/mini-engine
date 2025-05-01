package com.bootcamp.demo.data.game.flags;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.XmlReader;
import com.bootcamp.demo.data.game.IGameData;
import lombok.Getter;

public class FlagsGameData implements IGameData {
    @Getter
    private final ObjectMap<String, FlagGameData> flags = new ObjectMap<>();

    @Override
    public void load(XmlReader.Element rootXml) {
        flags.clear();
        Array<XmlReader.Element> flags1 = rootXml.getChildrenByName("flag");
        for (XmlReader.Element flag : flags1) {
            FlagGameData flagGameData = new FlagGameData();
            flagGameData.load(flag);
            flags.put(flagGameData.getName(), flagGameData);
        }

    }
}
