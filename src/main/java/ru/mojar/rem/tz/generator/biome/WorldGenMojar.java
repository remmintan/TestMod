package ru.mojar.rem.tz.generator.biome;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenMojar extends WorldGenerator {

    private Block generatedBlock;

    public WorldGenMojar(Block block){
        this.generatedBlock = block;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && !worldIn.isAirBlock(blockpos.down()) && worldIn.getBlockState(blockpos.down()).getBlock() != generatedBlock && generatedBlock.canPlaceBlockAt(worldIn, blockpos))
            {
                worldIn.setBlockState(blockpos, generatedBlock.getDefaultState(), 2);
            }
        }

        return true;
    }
}
