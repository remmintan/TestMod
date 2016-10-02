package ru.mojar.rem.tz.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.mojar.rem.tz.blocks.tile_entities.MojarTileEntitiy;
import ru.mojar.rem.tz.generator.block.MyBlockWorldGen;
import ru.mojar.rem.tz.other.ModInfo;

import java.util.HashMap;

public class BlockManager {

    public static final BlockManager ins = new BlockManager();

    private  final HashMap<Class<? extends Block>, String> registeredNames = new HashMap();

    public  void registerBlocks(){


        Block threeColor = new MyBlock();
        registerBlock(threeColor, new Object[] {"###","###", "###", '#', Blocks.GOLD_BLOCK});
        //addToWorldGen(threeColor, MyBlockWorldGen.class);

        Block mina = new MinaBlock();
        registerBlock(mina);

        //TileEntities first!
        registerTileEntity(MojarTileEntitiy.class, MojarTileEntitiy.defaultName);
    }

    private  void registerBlock(Block block){
        ItemBlock mojarItem = new ItemBlock(block);
        mojarItem.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(mojarItem, 0, new ModelResourceLocation(ModInfo.MODID+":"+block.getUnlocalizedName().substring(5), "inventory"));

        GameRegistry.register(block.setRegistryName(block.getUnlocalizedName().substring(5)));
        GameRegistry.register(mojarItem.setRegistryName(block.getRegistryName()));

        registeredNames.put(block.getClass(), getFullName(block));
    }

    private  void registerBlock(Block block, Object[] recipe){
        ItemBlock mojarItem = new ItemBlock(block);
        mojarItem.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(mojarItem, 0, new ModelResourceLocation(ModInfo.MODID+":"+block.getUnlocalizedName().substring(5), "inventory"));

        GameRegistry.register(block.setRegistryName(block.getUnlocalizedName().substring(5)));
        GameRegistry.register(mojarItem.setRegistryName(block.getRegistryName()));

        GameRegistry.addRecipe(new ItemStack(mojarItem), recipe);
        registeredNames.put(block.getClass(), getFullName(block));
    }

    private void registerTileEntity(Class<? extends TileEntity> cls, String name){
        GameRegistry.registerTileEntity(cls, name);
    }

    private  void addToWorldGen(Block block, Class<? extends IWorldGenerator> worldGen){
        try {
            IWorldGenerator generator = worldGen.newInstance();
            if(generator instanceof MyBlockWorldGen)((MyBlockWorldGen)generator).setBlock(block);
            GameRegistry.registerWorldGenerator(generator, 0);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private  String getFullName(Block block){
        String domain = block.getRegistryName().getResourceDomain();
        String path = block.getRegistryName().getResourcePath();

        return domain+":"+path;
    }

    public String getNameFromClass(Class<? extends Block> cls){
        if(registeredNames.containsKey(cls)){
            return registeredNames.get(cls);
        }else{
            return getFullName(Blocks.BEDROCK); //дефолтный блок
        }
    }

}
