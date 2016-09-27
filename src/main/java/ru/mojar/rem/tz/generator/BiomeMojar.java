package ru.mojar.rem.tz.generator;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMojar extends Biome{
    private static BiomeProperties properties = (new BiomeProperties("Mojar DESERT")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled();
    public BiomeMojar() {
        super(properties);

        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.BRICK_BLOCK.getDefaultState();
        this.fillerBlock = Blocks.COAL_BLOCK.getDefaultState();

        Biome.registerBiome(40, "mojar", this);
    }
}
