package ru.mojar.rem.tz.items;

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
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
        if(!isBlockSutiable(world, pos) || isBlockSutiable(world, pos1)) return EnumActionResult.PASS;
        BlockPos temp;
        for(int i = -3; i<4; i+=3){
            for(int j= -3; j<4; j+=3){
                temp = new BlockPos(pos1.getX()+i, pos1.getY(), pos1.getZ()+j);
                if(!world.isAirBlock(temp))continue;
                world.setBlockState(temp, Blocks.SAPLING.getDefaultState());
            }
        }

        System.out.println(pos + " "+pos1);
        return EnumActionResult.SUCCESS;
    }



    private boolean isBlockSutiable(World world, BlockPos pos){
        return world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.GRASS;

    }
}
