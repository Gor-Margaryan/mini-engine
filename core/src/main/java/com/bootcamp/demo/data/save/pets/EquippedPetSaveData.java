package com.bootcamp.demo.data.save.pets;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import lombok.Getter;
import lombok.Setter;

public class EquippedPetSaveData implements Json.Serializable{
    @Getter
    @Setter
    private String name;
    @Override
    public void write(Json json) {
        json.writeValue("n", name);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        name = jsonValue.getString("n");
    }
}
