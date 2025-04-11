package com.bootcamp.demo.pages.containers;


import com.badlogic.gdx.scenes.scene2d.ui.Table;


public class CommonEquipContainer extends Table {
    public CommonEquipContainer() {

        Table yxq = new Table();
        EquipSlotContainer equipSlotContainer = new EquipSlotContainer();
        FlagSlot flagSlot = new FlagSlot();

        yxq.add(equipSlotContainer).expand().top().size(220,220).pad(10);
        yxq.row();
        yxq.add(flagSlot).expand().bottom().size(220,220).pad(10);

        AnimalSlot animalSlot = new AnimalSlot();

        this.add(yxq).expand().fill().space(10);
        this.add(animalSlot).expand().fill().pad(10);
        
    }
}
