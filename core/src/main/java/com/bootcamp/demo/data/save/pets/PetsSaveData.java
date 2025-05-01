package com.bootcamp.demo.data.save.pets;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;
import lombok.Getter;

public class PetsSaveData implements Json.Serializable{
    @Getter
    private final ObjectMap<String,PetSaveData> pets = new ObjectMap<>();
    @Override
    public void write(Json json) {
        for (ObjectMap.Entry<String,PetSaveData> entry : pets.entries()) {
            json.writeValue(entry.key, entry.value);
        }

    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        pets.clear();
        for (JsonValue value : jsonValue){
            String name = value.name;
            PetSaveData petSaveData = json.readValue(PetSaveData.class, value);
            pets.put(name,petSaveData);
        }


    }
}
