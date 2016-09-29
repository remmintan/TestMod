package ru.mojar.rem.tz.generator;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class Dimension {

    public static void registerDimension(){
        DimensionType.register(DimensionInfo.DIMENSION_TYPE_NAME, DimensionInfo.DIMENSION_TYPE_SUFFIX, DimensionInfo.DIMENSION_TYPE_ID, WorldProviderMojar.class, true);

        if(DimensionManager.isDimensionRegistered(DimensionInfo.DIMENSION_ID)){
            DimensionManager.unregisterDimension(DimensionInfo.DIMENSION_ID);
        }

        DimensionType dt = DimensionType.getById(DimensionInfo.DIMENSION_TYPE_ID);

        DimensionManager.registerDimension(DimensionInfo.DIMENSION_ID, dt);
    }

}
