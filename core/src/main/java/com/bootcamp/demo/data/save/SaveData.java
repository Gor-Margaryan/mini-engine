package com.bootcamp.demo.data.save;


import com.bootcamp.demo.data.save.equips.EquipsSaveData;
import com.bootcamp.demo.data.save.flags.FlagsSaveData;
import com.bootcamp.demo.data.save.tactics.TacticsSaveData;
import lombok.Getter;

public class SaveData {

    @Getter
    private final EquipsSaveData equipsSaveData = new EquipsSaveData();
    @Getter
    private final TacticsSaveData tacticsSaveData = new TacticsSaveData();
    @Getter
    private final FlagsSaveData flagsSaveData = new FlagsSaveData();
}
