package com.bootcamp.demo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.*;
import com.bootcamp.demo.data.game.GameData;
import com.bootcamp.demo.data.game.equips.enums.EquipType;
import com.bootcamp.demo.data.save.SaveData;
import com.bootcamp.demo.data.save.equips.EquipSaveData;
import com.bootcamp.demo.data.save.equips.enums.EquipRarity;
import com.bootcamp.demo.data.save.stats.StatsSaveData;
import com.bootcamp.demo.data.save.stats.enums.Stat;
import com.bootcamp.demo.events.GameStartedEvent;
import com.bootcamp.demo.managers.API;
import com.bootcamp.demo.events.core.EventModule;


import static com.badlogic.gdx.math.MathUtils.random;

public class DemoGame extends Game {

    @Override
    public void create() {
        Gdx.input.setInputProcessor(new InputMultiplexer());

        final GameData gameData = new GameData();
        API.Instance().register(GameData.class, gameData);
        gameData.load();

        loadSaveData();
        EquipRarity[] values = EquipRarity.values();

        final EquipSaveData equipSaveData = new EquipSaveData();
        equipSaveData.setName("weapon");
        equipSaveData.setLevel(random.nextInt(1, 50));
        equipSaveData.setEquipRarity(values[random.nextInt(0,15)]);
        equipSaveData.setPower(random.nextFloat(1,5));

        final StatsSaveData statsSaveData = new StatsSaveData();
        ObjectMap<Stat, Float> stats = statsSaveData.getStats();
        stats.put(Stat.HP, random.nextFloat(1,5));
        stats.put(Stat.ATK, random.nextFloat(1,5));
        statsSaveData.setStats(stats);
        equipSaveData.setStatsSaveData(statsSaveData);

        final EquipSaveData equipSaveData1 = new EquipSaveData();
        equipSaveData1.setName("melee");
        equipSaveData1.setLevel(random.nextInt(1, 50));
        equipSaveData1.setEquipRarity(values[random.nextInt(0,15)]);
        equipSaveData1.setPower(random.nextFloat(1,5));

        final StatsSaveData statsSaveData1 = new StatsSaveData();
        ObjectMap<Stat, Float> stats1 = statsSaveData1.getStats();
        stats1.put(Stat.HP, random.nextFloat(1,5));
        stats1.put(Stat.ATK, random.nextFloat(1,5));
        statsSaveData1.setStats(stats1);
        equipSaveData1.setStatsSaveData(statsSaveData1);

        final EquipSaveData equipSaveData2 = new EquipSaveData();
        equipSaveData2.setName("head");
        equipSaveData2.setLevel(random.nextInt(1, 50));
        equipSaveData2.setEquipRarity(values[random.nextInt(0,15)]);
        equipSaveData2.setPower(random.nextFloat(1,5));

        final StatsSaveData statsSaveData2 = new StatsSaveData();
        ObjectMap<Stat, Float> stats2 = statsSaveData2.getStats();
        stats2.put(Stat.HP, random.nextFloat(1,5));
        stats2.put(Stat.ATK, random.nextFloat(1,5));
        statsSaveData2.setStats(stats2);
        equipSaveData2.setStatsSaveData(statsSaveData2);

        final EquipSaveData equipSaveData3 = new EquipSaveData();
        equipSaveData3.setName("body");
        equipSaveData3.setLevel(random.nextInt(1, 50));
        equipSaveData3.setEquipRarity(values[random.nextInt(0,15)]);
        equipSaveData3.setPower(random.nextFloat(1,5));

        final StatsSaveData statsSaveData3 = new StatsSaveData();
        ObjectMap<Stat, Float> stats3 = statsSaveData3.getStats();
        stats3.put(Stat.HP, random.nextFloat(1,5));
        stats3.put(Stat.ATK, random.nextFloat(1,5));
        statsSaveData3.setStats(stats3);
        equipSaveData3.setStatsSaveData(statsSaveData3);

        final EquipSaveData equipSaveData4 = new EquipSaveData();
        equipSaveData4.setName("gloves");
        equipSaveData4.setLevel(random.nextInt(1, 50));
        equipSaveData4.setEquipRarity(values[random.nextInt(0,15)]);
        equipSaveData4.setPower(random.nextFloat(1,5));

        final StatsSaveData statsSaveData4 = new StatsSaveData();
        ObjectMap<Stat, Float> stats4 = statsSaveData4.getStats();
        stats4.put(Stat.HP, random.nextFloat(1,5));
        stats4.put(Stat.ATK, random.nextFloat(1,5));
        statsSaveData4.setStats(stats4);
        equipSaveData4.setStatsSaveData(statsSaveData4);

        final EquipSaveData equipSaveData5 = new EquipSaveData();
        equipSaveData5.setName("shoes");
        equipSaveData5.setLevel(random.nextInt(1, 50));
        equipSaveData5.setEquipRarity(values[random.nextInt(0,15)]);
        equipSaveData5.setPower(random.nextFloat(1,5));

        final StatsSaveData statsSaveData5 = new StatsSaveData();
        ObjectMap<Stat, Float> stats5 = statsSaveData.getStats();
        stats5.put(Stat.HP, random.nextFloat(1,5));
        stats5.put(Stat.ATK, random.nextFloat(1,5));
        statsSaveData5.setStats(stats5);
        equipSaveData5.setStatsSaveData(statsSaveData5);

        API.get(SaveData.class).getEquipsSaveData().getEquips().put(EquipType.WEAPON, equipSaveData);
        API.get(SaveData.class).getEquipsSaveData().getEquips().put(EquipType.MELEE, equipSaveData1);
        API.get(SaveData.class).getEquipsSaveData().getEquips().put(EquipType.HEAD, equipSaveData2);
        API.get(SaveData.class).getEquipsSaveData().getEquips().put(EquipType.BODY, equipSaveData3);
        API.get(SaveData.class).getEquipsSaveData().getEquips().put(EquipType.GLOVES, equipSaveData4);
        API.get(SaveData.class).getEquipsSaveData().getEquips().put(EquipType.SHOES, equipSaveData5);

        savePlayerData();

        setScreen(new GameScreen());
        API.get(EventModule.class).fireEvent(GameStartedEvent.class);
    }

    private void loadSaveData() {
        final FileHandle file = getPlayerDataFileHandler();
        if (!file.exists()) {
            createNewSaveData();
            return;
        }

        final JsonReader jsonReader = new JsonReader();
        final Json json = new Json();
        json.setIgnoreUnknownFields(true);

        final String dataString = file.readString();
        final JsonValue jsonValue = jsonReader.parse(dataString);
        final SaveData saveData = json.readValue(SaveData.class, jsonValue);
        API.Instance().register(SaveData.class, saveData);
    }

    private void createNewSaveData() {
        final SaveData saveData = new SaveData();
        API.Instance().register(SaveData.class, saveData);
        savePlayerData();
    }

    public void savePlayerData() {
        final SaveData saveData = API.get(SaveData.class);

        final Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        json.setIgnoreUnknownFields(true);

        final String dataToPersist = json.toJson(saveData);
        getPlayerDataFileHandler().writeString(dataToPersist, false);
    }

    private FileHandle getPlayerDataFileHandler() {
        final FileHandle playerDataFile = Gdx.files.local("usercache").child("player-data");
        // check if file exists; if not, create an empty file
        if (!playerDataFile.exists()) {
            playerDataFile.writeString("", false);
        }
        return playerDataFile;
    }

    @Override
    public void dispose() {
        super.dispose();
        API.Instance().dispose();
        Gdx.app.exit();
    }
}
