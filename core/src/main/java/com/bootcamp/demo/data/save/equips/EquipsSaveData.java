package com.bootcamp.demo.data.save.equips;


import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.game.equips.enums.EquipType;
import lombok.Getter;

import java.util.Locale;

public class EquipsSaveData implements Json.Serializable {
    @Getter
    private final ObjectMap<EquipType, EquipSaveData> equips = new ObjectMap<>();

    @Override
    public void write(Json json) {
        for (ObjectMap.Entry <EquipType, EquipSaveData> entry : equips.entries()) {
            json.writeValue(entry.key.name(), entry.value);
        }


    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        equips.clear();
        for (JsonValue value : jsonValue) {
            final EquipType equipType = EquipType.valueOf(value.name.toUpperCase(Locale.ENGLISH));
            final EquipSaveData equipSaveData = json.readValue(EquipSaveData.class, value);
            equips.put(equipType, equipSaveData);
        }
    }
}
