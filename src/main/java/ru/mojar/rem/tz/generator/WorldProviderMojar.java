package ru.mojar.rem.tz.generator;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.Biome;

public class WorldProviderMojar extends WorldProviderSurface {

    @Override
    public DimensionType getDimensionType() {
        return DimensionType.getById(DimensionInfo.DIMENSION_ID);
    }

    @Override
    public void createBiomeProvider(){
        if(worldObj.getWorldType().getClass() != WorldTypeMojar.class){
            super.createBiomeProvider();
            return;
        }

        Biome mainB = Biome.REGISTRY.getObject(new ResourceLocation(DimensionInfo.BIOME_NAME));
        if(mainB != null){
            this.biomeProvider = new net.minecraft.world.biome.BiomeProviderSingle(mainB);
        }
    }

    @Override
    /** sets/creates the save folder */
    public String getSaveFolder() {
        if(worldObj.getWorldType().getClass() != WorldTypeMojar.class){
            return super.getSaveFolder();
        }

        return "DIM" + DimensionInfo.DIMENSION_TYPE_NAME;
    }

}
