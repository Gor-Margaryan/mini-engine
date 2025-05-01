package com.bootcamp.demo.data.game.tactics;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.XmlReader;
import com.bootcamp.demo.data.game.IGameData;
import lombok.Getter;

public class TacticsGameData implements IGameData {
    @Getter
    private final ObjectMap<String, TacticGameData> tactics = new ObjectMap<>();
    @Override
    public void load(XmlReader.Element rootXml) {
        tactics.clear();
        Array<XmlReader.Element> tactics1 = rootXml.getChildrenByName("tactic");
        for (XmlReader.Element tactic1 : tactics1) {
            TacticGameData tactic = new TacticGameData();
            tactic.load(tactic1);
            tactics.put(tactic.getName(), tactic);
        }
    }
}
