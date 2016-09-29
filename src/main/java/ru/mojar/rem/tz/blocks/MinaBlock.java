package ru.mojar.rem.tz.blocks;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.mojar.rem.tz.other.ModInfo;

public class MinaBlock extends BlockPressurePlate{

    public static String registryName;

    public MinaBlock() {
        super(Material.GRASS, BlockPressurePlate.Sensitivity.EVERYTHING);

        this.setUnlocalizedName("mojar_mina");

        ItemBlock mojarItem = new ItemBlock(this);
        mojarItem.setCreativeTab(CreativeTabs.REDSTONE);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(mojarItem, 0, new ModelResourceLocation(ModInfo.MODID+":"+this.getUnlocalizedName().substring(5), "inventory"));
        GameRegistry.register(this.setRegistryName(this.getUnlocalizedName().substring(5))); //название совпадается с UnlocalizedName. хз почему, но по другому не работает. позднее разберусь
        GameRegistry.register(mojarItem.setRegistryName(this.getRegistryName()));


        registryName = this.getRegistryName().getResourceDomain()+":"+this.getRegistryName().getResourcePath();
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if (!worldIn.isRemote )
        {
            int i = this.getRedstoneStrength(state);

            if (i == 0)
            {
                this.updateState(worldIn, pos, state, i);

            }else{
                worldIn.createExplosion(entityIn, pos.getX(), pos.getY(), pos.getZ(), 4.0f, true);
                //TODO damag poluchaet tot, kto vstal na plitu. ostalnie net. ISPRAVIT!!!
                if(entityIn instanceof EntityLivingBase) entityIn.attackEntityFrom(DamageSource.causeExplosionDamage((EntityLivingBase)entityIn), 12);
            }
        }
    }
}
