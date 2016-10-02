package ru.mojar.rem.tz.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.mojar.rem.tz.TZ;
import ru.mojar.rem.tz.blocks.tile_entities.MojarTileEntitiy;
import ru.mojar.rem.tz.gui.GuiManager;

import javax.annotation.Nullable;
import java.util.Random;

public class MyBlock extends Block implements ITileEntityProvider{
    private static Random r = new Random();
   //private boolean isGoingToExplode = true;

    public MyBlock() {
        super(Material.ROCK);

        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setBlockUnbreakable();
        this.setUnlocalizedName("block_mojar");// это название должно совпадать с названием в json'ах
    }

    //на открытие меню я пока забил, стоит этим заняться вместе с GUI
    @Override
    public boolean onBlockActivated(World worldIn,
                                    BlockPos pos,
                                    IBlockState state,
                                    EntityPlayer playerIn,
                                    EnumHand hand,
                                    @Nullable ItemStack heldItem,
                                    EnumFacing side,
                                    float hitX,
                                    float hitY,
                                    float hitZ){
        if(worldIn.isRemote){
            if(r.nextFloat()<0f){
                worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 6, true); //срабатывает с вероятностью 50%
            }else{
                playerIn.openGui(TZ.modIns, GuiManager.MOJAR_GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new MojarTileEntitiy();
    }
}
