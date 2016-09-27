package ru.mojar.rem.tz.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.mojar.rem.tz.other.ModInfo;

import javax.annotation.Nullable;
import java.util.Random;

public class MyBlock extends Block{
    private static Random r = new Random();

    public MyBlock() {
        super(Material.GROUND); // я уже забыл почему это так. на веру короче.

        //далее устанавливаются свойства блока. о них достаточно можно погуглить
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS); // устанавливает
        this.setBlockUnbreakable(); //говорит за себя. блок неразрушаем.
        this.setUnlocalizedName("block_mojar");// это название должно совпадать с названием в json'ах

        ItemBlock mojarItem = new ItemBlock(this);
        mojarItem.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(mojarItem, 0, new ModelResourceLocation(ModInfo.MODID+":"+this.getUnlocalizedName().substring(5), "inventory"));
        GameRegistry.register(this.setRegistryName(this.getUnlocalizedName().substring(5))); //название совпадается с UnlocalizedName. хз почему, но по другому не работает. позднее разберусь
        GameRegistry.register(mojarItem.setRegistryName(this.getRegistryName()));
        MyBlockWorldGen generator = new MyBlockWorldGen(this);
        GameRegistry.registerWorldGenerator(generator, 0);
        GameRegistry.addRecipe(new ItemStack(mojarItem), "###","###", "###", '#', Blocks.GOLD_BLOCK);
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
        if(worldIn.isRemote) return false; // эта строчка необходима пре работе со врзывами. проверяет, локальный это мир или серверрный. в падлу объяснять все в комментарии, просто принять на веру!
        if(r.nextFloat()<0.5f){
            //просто создает взрыв на месте блока. радиус взрыва - 6 блоков
            worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 6, true); //срабатывает с вероятностью 50%
        }

        return true;
    }
}
