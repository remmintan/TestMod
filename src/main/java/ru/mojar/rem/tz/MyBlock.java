package ru.mojar.rem.tz;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MyBlock extends Block{
    public MyBlock() {
        super(Material.GROUND);

        //далее устанавливаются свойства блока. о них достаточно можно погуглить
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS); // устанавливает
        this.setBlockUnbreakable(); //говорит за себя. блок неразрушаем.
        this.setUnlocalizedName("block_mojar");// это название должно совпадать с названием в json'ах


    }
}
