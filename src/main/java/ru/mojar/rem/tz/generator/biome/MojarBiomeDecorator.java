package ru.mojar.rem.tz.generator.biome;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import ru.mojar.rem.tz.TZ;
import ru.mojar.rem.tz.blocks.BlockManager;
import ru.mojar.rem.tz.blocks.MinaBlock;

import java.util.Random;

public class MojarBiomeDecorator extends BiomeDecorator{

    @Override
    protected void genDecorations(Biome biomeGenBaseIn, World worldIn, Random random){

        super.genDecorations(biomeGenBaseIn, worldIn, random);

        for(int i = 0; i< 15; i++){
            int i5 = random.nextInt(16) + 8;
            int k9 = random.nextInt(16) + 8;
            int j13 = worldIn.getHeight(this.chunkPos.add(i5, 0, k9)).getY() * 2;

            if (j13 > 0)
            {
                int k16 = random.nextInt(j13);
                Block mj = Block.getBlockFromName(BlockManager.ins.getNameFromClass(MinaBlock.class));
                if(mj == null) throw new RuntimeException(TZ.DEBUG_PREFIX+"Null pointer");
                (new WorldGenMojar(mj)).generate(worldIn, random, this.chunkPos.add(i5, k16, k9));
            }
        }
    }

}
