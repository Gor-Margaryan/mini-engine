package com.bootcamp.demo.data.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.bootcamp.demo.data.game.equips.EquipsGameData;
import com.bootcamp.demo.data.game.flags.FlagsGameData;
import com.bootcamp.demo.data.game.pets.PetsGameData;
import com.bootcamp.demo.data.game.tactics.TacticsGameData;
import lombok.Getter;

public class GameData {

    private final XmlReader xmlReader = new XmlReader();

    @Getter
    private final EquipsGameData equipsGameData;
    @Getter
    private final TacticsGameData tacticsGameData;
    @Getter
    private final FlagsGameData flagsGameData;
    @Getter
    private final PetsGameData petsGameData;

    public GameData () {
        equipsGameData = new EquipsGameData();
        tacticsGameData = new TacticsGameData();
        flagsGameData = new FlagsGameData();
        petsGameData = new PetsGameData();
    }

    public void load () {
        equipsGameData.load(xmlReader.parse(Gdx.files.internal("data/equips.xml")));
        tacticsGameData.load(xmlReader.parse(Gdx.files.internal("data/tactics.xml")));
        flagsGameData.load(xmlReader.parse(Gdx.files.internal("data/flags.xml")));
        petsGameData.load(xmlReader.parse(Gdx.files.internal("data/pets.xml")));
    }
}
