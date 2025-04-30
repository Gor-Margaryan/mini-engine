package com.bootcamp.demo.data.save.equips;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.bootcamp.demo.data.save.equips.enums.EquipRarity;
import com.bootcamp.demo.data.save.stats.StatsSaveData;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

public class EquipSaveData implements Json.Serializable{
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int level;
    @Getter
    @Setter
    private EquipRarity equipRarity;
    @Getter
    @Setter
    private float power;
    @Getter
    @Setter
    private StatsSaveData statsSaveData;

    @Override
    public void write(Json json) {
        json.writeValue("n", name);
        json.writeValue("l", level);
        json.writeValue("er", equipRarity.name());
        json.writeValue("p", power);
        json.writeValue("s", statsSaveData);


    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        name = jsonValue.getString("n");
        level = jsonValue.getInt("l");
        equipRarity = EquipRarity.valueOf(jsonValue.getString("er").toUpperCase(Locale.ENGLISH));
        power = jsonValue.getFloat("p");
        statsSaveData = json.readValue(StatsSaveData.class, jsonValue.get("s"));
    }
}
