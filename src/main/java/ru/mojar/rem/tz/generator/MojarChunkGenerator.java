package ru.mojar.rem.tz.generator;

import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderOverworld;

public class MojarChunkGenerator extends ChunkProviderOverworld {

    public MojarChunkGenerator(World worldIn, long seed) {
        super(worldIn, seed, false, "");
    }


}
