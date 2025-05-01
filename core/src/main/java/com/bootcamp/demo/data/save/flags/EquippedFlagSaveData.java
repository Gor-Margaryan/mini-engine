package com.bootcamp.demo.data.save.flags;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import lombok.Getter;
import lombok.Setter;

public class EquippedFlagSaveData implements Json.Serializable{
    @Getter
    @Setter
    private String flagName;
    @Override
    public void write(Json json) {
        json.writeValue("f", flagName);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        flagName = jsonValue.getString("f");

    }
}
