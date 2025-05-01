package com.bootcamp.demo.data.save.stats;

import com.badlogic.gdx.utils.ObjectMap;
import com.bootcamp.demo.data.game.GameData;
import com.bootcamp.demo.data.game.equips.enums.EquipType;
import com.bootcamp.demo.data.game.tactics.TacticGameData;
import com.bootcamp.demo.data.save.SaveData;
import com.bootcamp.demo.data.save.equips.EquipSaveData;
import com.bootcamp.demo.data.save.stats.enums.Stat;
import com.bootcamp.demo.data.save.tactics.TacticSaveData;
import com.bootcamp.demo.managers.API;

public class StatsManager {
    public static ObjectMap<Stat, Float> getAllStats(SaveData saveData) {
        ObjectMap<Stat, Float> allStats = new ObjectMap<>();
        for (Stat stat : Stat.values()) {
            allStats.put(stat, 0f);
        }

        ObjectMap<EquipType, EquipSaveData> equips = saveData.getEquipsSaveData().getEquips();
        for (ObjectMap.Entry<EquipType, EquipSaveData> entry : equips.entries()) {
            for (ObjectMap.Entry<Stat, Float> entry1 : entry.value.getStatsSaveData().getStats().entries()) {
                allStats.put(entry1.key, allStats.get(entry1.key) + entry1.value);
            }
        }

        ObjectMap<String, TacticGameData> tactics1 = API.get(GameData.class).getTacticsGameData().getTactics();
        ObjectMap<String, TacticSaveData> tactics = saveData.getTacticsSaveData().getTactics();
        for (ObjectMap.Entry<String, TacticSaveData> entry : tactics.entries()) {
            TacticGameData tacticGameData = tactics1.get(entry.key);
            allStats.put(Stat.HP, allStats.get(Stat.HP) + tacticGameData.getHP());
            allStats.put(Stat.ATK,allStats.get(Stat.ATK) + tacticGameData.getATK());
        }


        return allStats;
    }
}
