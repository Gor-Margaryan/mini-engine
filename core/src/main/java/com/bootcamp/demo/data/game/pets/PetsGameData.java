package com.bootcamp.demo.data.game.pets;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.XmlReader;
import com.bootcamp.demo.data.game.IGameData;
import lombok.Getter;

public class PetsGameData implements IGameData {
    @Getter
    private final ObjectMap<String, PetGameData> pets = new ObjectMap<>();
    @Override
    public void load(XmlReader.Element rootXml) {
        pets.clear();
        Array<XmlReader.Element> petsXML = rootXml.getChildrenByName("pet");
        for (XmlReader.Element petXML : petsXML) {
            PetGameData petGameData = new PetGameData();
            petGameData.load(petXML);
            pets.put(petGameData.getName(), petGameData);
        }


    }
}
