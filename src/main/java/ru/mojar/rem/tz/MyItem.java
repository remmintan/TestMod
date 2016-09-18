package ru.mojar.rem.tz;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MyItem extends Item{

    public MyItem(){
        super();

        this.setUnlocalizedName("item_mojar");
        this.setCreativeTab(CreativeTabs.TOOLS);


    }

    @Override
    public EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
        if(world.isRemote) return EnumActionResult.PASS;

        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
        if(!isBlockSutiable(world, pos) || !isBlockSutiable(world, pos1)) return EnumActionResult.PASS;
        world.setBlockState(pos1, Blocks.BEDROCK.getDefaultState());
        return EnumActionResult.SUCCESS;
    }

    private boolean isBlockSutiable(World world, BlockPos pos){
        return world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.GRASS;

    }
}
