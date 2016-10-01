package ru.mojar.rem.tz.generator.biome;

import net.minecraft.world.biome.Biome;
import ru.mojar.rem.tz.generator.dimension.DimensionInfo;

public class BiomeMojar extends Biome {

    public BiomeMojar() {
        super((new Biome.BiomeProperties(DimensionInfo.BIOME_NAME)).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(1F));

        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.clear();
    }

}
