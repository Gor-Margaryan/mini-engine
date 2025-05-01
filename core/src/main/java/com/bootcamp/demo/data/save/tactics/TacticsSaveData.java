package com.bootcamp.demo.data.save.tactics;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;
import lombok.Getter;

public class TacticsSaveData implements Json.Serializable {
    @Getter
    private final ObjectMap<String, TacticSaveData> tactics = new ObjectMap<>();

    @Override
    public void write(Json json) {
        for (ObjectMap.Entry<String, TacticSaveData> entry : tactics.entries()) {
            json.writeValue(entry.key, entry.value);
        }

    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        tactics.clear();
        for (JsonValue value : jsonValue) {
            String name = value.name;
            TacticSaveData tacticSaveData = json.readValue(TacticSaveData.class, value);
            tactics.put(name, tacticSaveData);
        }

    }
}
