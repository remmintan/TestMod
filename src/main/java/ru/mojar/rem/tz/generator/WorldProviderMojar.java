package ru.mojar.rem.tz.generator;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderMojar extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.getById(DimensionInfo.DIMENSION_ID);

    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new MojarChunkGenerator(this.worldObj, this.getSeed(), false, "");
    }

    @Override
    /** sets/creates the save folder */
    public String getSaveFolder() {
        return "DIM" + DimensionInfo.DIMENSION_TYPE_NAME;
    }

    @SideOnly(Side.CLIENT)
    /** @return the player speed */
    public double getMovementFactor() {
        return 0.1;
    }

    @SideOnly(Side.CLIENT)
    /** should a color for the sky be rendered? */
    public boolean isSkyColored()
    {
        return true;
    }

    @Override
    /** can the player respawn in this dimension? */
    public boolean canRespawnHere()
    {
        return true;
    }

    @Override
    /** is this a surface world or an underworld */
    public boolean isSurfaceWorld()
    {
        return true;
    }

    @Override
    /** the light value in this dimension */
    protected void generateLightBrightnessTable()
    {
        float f = 0.0F;

        for (int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    /** @return the dimension join message */
    public String getWelcomeMessage()
    {
        return "Entering the Forest";
    }

    @Override
    @SideOnly(Side.CLIENT)
    /** @return the dimension leave message */
    public String getDepartMessage()
    {
        return "Leaving the Forest";
    }



    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float par1, float par2)
    {
        float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        float f3 = 0.7529412F;
        float f4 = 0.84705883F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return new Vec3d((double)f3, (double)f4, (double)f5);
    }
}
