package ru.mojar.rem.tz;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class MyBlockWorldGen implements IWorldGenerator {

    private final Block trik;

    public MyBlockWorldGen(Block bl){
        trik = bl;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension())
        {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
            default:
        }
    }

    private void generateEnd(World world, Random random, int i, int i1) {

    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 16; k++)
        {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            //Will be found between y = 0 and y = 20
            int quisqueY = rand.nextInt(128);
            BlockPos quisquePos = new BlockPos(firstBlockXCoord, quisqueY, firstBlockZCoord);

            //The 10 as the second parameter sets the maximum vein size
            (new WorldGenMinable(trik.getDefaultState(), 25)).generate(world, rand, quisquePos);
        }
    }

    private void generateNether(World world, Random random, int i, int i1) {

    }


}

