package com.bootcamp.demo.data.save;


import com.bootcamp.demo.data.save.equips.EquipsSaveData;
import com.bootcamp.demo.data.save.flags.EquippedFlagSaveData;
import com.bootcamp.demo.data.save.flags.FlagsSaveData;
import com.bootcamp.demo.data.save.pets.EquippedPetSaveData;
import com.bootcamp.demo.data.save.pets.PetsSaveData;
import com.bootcamp.demo.data.save.tactics.EquippedTacticsSaveData;
import com.bootcamp.demo.data.save.tactics.TacticsSaveData;
import lombok.Getter;

public class SaveData {

    @Getter
    private final EquipsSaveData equipsSaveData = new EquipsSaveData();
    @Getter
    private final TacticsSaveData tacticsSaveData = new TacticsSaveData();
    @Getter
    private final EquippedTacticsSaveData equippedTacticsSaveData = new EquippedTacticsSaveData();
    @Getter
    private final FlagsSaveData flagsSaveData = new FlagsSaveData();
    @Getter
    private final EquippedFlagSaveData equippedFlagSaveData = new EquippedFlagSaveData();
    @Getter
    private final PetsSaveData petsSaveData = new PetsSaveData();
    @Getter
    private final EquippedPetSaveData equippedPetSaveData = new EquippedPetSaveData();
}
