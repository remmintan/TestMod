package ru.mojar.rem.tz;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TZ.MODID, name = TZ.MODNAME, version = TZ.VERSION)
public class TZ {

    public static final String MODID = "mojartz";
    public static final String MODNAME = "MoJar Teh. Zadanie";
    public static final String VERSION = "1.0.0";

    @Mod.EventHandler
    public void init (FMLInitializationEvent event){

        MyBlock mojarBlock = new MyBlock();
        ItemBlock mojarItem = new ItemBlock(mojarBlock);


        //// TODO: 17.09.2016 Fix item texture and rendering
        GameRegistry.register(mojarBlock.setRegistryName("block_mojar"));
        GameRegistry.register(mojarItem.setRegistryName(mojarBlock.getRegistryName()));

        //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getByNameOrId("block_mojar"), 0, new ModelResourceLocation(MODID+":"+mojarBlock.getUnlocalizedName().substring(5), "inventory"));

        GameRegistry.addRecipe(new ItemStack(mojarItem), new Object[] {"###","###", "###", '#', Blocks.GOLD_BLOCK});
    }





}
