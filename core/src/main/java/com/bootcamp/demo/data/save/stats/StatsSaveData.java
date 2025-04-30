package com.bootcamp.demo.data.save.stats;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.save.stats.enums.Stat;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

public class StatsSaveData implements Json.Serializable {
    @Getter @Setter
    private  ObjectMap<Stat, Float> stats = new ObjectMap<>();

    @Override
    public void write(Json json) {
        for (ObjectMap.Entry<Stat, Float> entry : stats.entries()) {
            json.writeValue(entry.key.name(), entry.value);
        }

    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        stats.clear();

        for (JsonValue value : jsonValue) {
            Stat stat = Stat.valueOf(value.name.toUpperCase(Locale.ENGLISH));
            Float v = json.readValue(Float.class, value);
            stats.put(stat, v);
        }


    }
}
