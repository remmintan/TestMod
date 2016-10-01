package ru.mojar.rem.tz.generator;

import net.minecraft.world.biome.Biome;
import ru.mojar.rem.tz.generator.biome.BiomeMojar;
import ru.mojar.rem.tz.generator.dimension.Dimension;
import ru.mojar.rem.tz.generator.dimension.DimensionInfo;
import ru.mojar.rem.tz.generator.dimension.WorldTypeMojar;

public class DimensionManagerM {

    public static void registerDimensions(){
        Biome mojar = new BiomeMojar();
        Biome.registerBiome(40, DimensionInfo.BIOME_NAME, mojar);

        WorldTypeMojar.addWorldType();
        Dimension.registerDimension();
    }

}
