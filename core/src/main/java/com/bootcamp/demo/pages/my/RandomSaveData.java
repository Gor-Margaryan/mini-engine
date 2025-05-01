package com.bootcamp.demo.pages.my;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.game.GameData;
import com.bootcamp.demo.data.game.equips.EquipGameData;
import com.bootcamp.demo.data.game.flags.FlagGameData;
import com.bootcamp.demo.data.game.tactics.TacticGameData;
import com.bootcamp.demo.data.save.SaveData;
import com.bootcamp.demo.data.save.equips.EquipSaveData;
import com.bootcamp.demo.data.save.equips.enums.EquipRarity;
import com.bootcamp.demo.data.save.flags.FlagSaveData;
import com.bootcamp.demo.data.save.stats.StatsSaveData;
import com.bootcamp.demo.data.save.stats.enums.Stat;
import com.bootcamp.demo.data.save.tactics.TacticSaveData;
import com.bootcamp.demo.managers.API;

import static com.badlogic.gdx.math.MathUtils.random;

public class RandomSaveData {
    public static void getRandomEquipSaveData(GameData gameData) {
        ObjectMap<String, EquipGameData> equips = gameData.getEquipsGameData().getEquips();
        Array<String> array = equips.keys().toArray();
        EquipRarity[] values = EquipRarity.values();
        Stat[] stats = Stat.values();


        EquipSaveData equipSaveData = new EquipSaveData();
        equipSaveData.setName(array.random());
        equipSaveData.setLevel(random.nextInt(1, 10));
        equipSaveData.setEquipRarity(values[random.nextInt(0,15)]);
        equipSaveData.setPower(random.nextFloat(1,5));

        final StatsSaveData statsSaveData = new StatsSaveData();
        ObjectMap<Stat, Float> stats1 = statsSaveData.getStats();
        stats1.put(stats[random.nextInt(0,8)], random.nextFloat(1,5));
        stats1.put(stats[random.nextInt(0,8)], random.nextFloat(1,5));
        statsSaveData.setStats(stats1);
        equipSaveData.setStatsSaveData(statsSaveData);

        API.get(SaveData.class).getEquipsSaveData().getEquips().put(equips.get(equipSaveData.getName()).getEquipType(), equipSaveData);
    }
    public static void getRandomTacticSaveData (GameData gameData) {
        ObjectMap<String, TacticGameData> tactics = gameData.getTacticsGameData().getTactics();
        Array<String> array = tactics.keys().toArray();

        TacticSaveData tacticSaveData = new TacticSaveData();
        tacticSaveData.setName(array.random());
        tacticSaveData.setLevel(random.nextInt(1,10));

        API.get(SaveData.class).getTacticsSaveData().getTactics().put(tacticSaveData.getName(), tacticSaveData);
    }

    public static void getRandomFlagSaveData (GameData gameData) {
        ObjectMap<String, FlagGameData> flags = gameData.getFlagsGameData().getFlags();
        Array<String> array = flags.keys().toArray();

        FlagSaveData flagSaveData = new FlagSaveData();
        flagSaveData.setName(array.random());
        flagSaveData.setLevel(random.nextInt(1,10));

        API.get(SaveData.class).getFlagsSaveData().getFlags().put(flagSaveData.getName(), flagSaveData);
        API.get(SaveData.class).getFlagsSaveData().setEquippedFlag(flagSaveData.getName());
    }
}
