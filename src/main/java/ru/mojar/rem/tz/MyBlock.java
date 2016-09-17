package ru.mojar.rem.tz;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MyBlock extends Block{
    public MyBlock() {
        super(Material.GROUND);

        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setBlockUnbreakable();
        this.setUnlocalizedName("mojar_rem_block");


    }
}
