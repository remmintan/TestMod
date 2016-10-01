package ru.mojar.rem.tz.blocks;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class MinaBlock extends BlockPressurePlate{

    public MinaBlock() {
        super(Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
        this.setUnlocalizedName("mojar_mina");
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
                worldIn.createExplosion(entityIn, pos.getX(), pos.getY(), pos.getZ(), 4.0f, true);
                if(entityIn instanceof EntityLivingBase) entityIn.attackEntityFrom(DamageSource.causeExplosionDamage((EntityLivingBase)entityIn), 12);
            }
        }
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 0;
    }
}
