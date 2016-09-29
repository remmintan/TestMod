package ru.mojar.rem.tz.generator;

import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderFlat;

public class MojarChunkGenerator extends ChunkProviderFlat {

    public MojarChunkGenerator(World worldIn, long seed, boolean generateStructures, String flatGeneratorSettings) {
        super(worldIn, seed, generateStructures, flatGeneratorSettings);
    }
}
