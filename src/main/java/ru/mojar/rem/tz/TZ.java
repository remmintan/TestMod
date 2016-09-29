package ru.mojar.rem.tz;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.mojar.rem.tz.blocks.MyBlock;
import ru.mojar.rem.tz.generator.BiomeMojar;
import ru.mojar.rem.tz.generator.Dimension;
import ru.mojar.rem.tz.generator.DimensionInfo;
import ru.mojar.rem.tz.generator.WorldTypeMojar;
import ru.mojar.rem.tz.items.MojarBow;
import ru.mojar.rem.tz.items.MojarTestItem;
import ru.mojar.rem.tz.other.ModInfo;
import ru.mojar.rem.tz.other.MojarEventHandler;

@Mod(modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION)
public class TZ {

    public static final String DEBUG_PREFIX = "[MOJAR DEBUG]: ";

    @Mod.Instance(ModInfo.MODID)
    public static TZ modIns;

    //@SidedProxy(clientSide = "ru.mojar.rem.tz.web.ClientProxy", serverSide = "ru.mojar.rem.tz.web.CommonProxy")
    //private static CommonProxy proxy;

    @Mod.EventHandler
    public void fmlLifeCycle(FMLPreInitializationEvent event){
        modIns = this;
    }

    @Mod.EventHandler
    public void fmlLifeCycle(FMLInitializationEvent event){
        MojarEventHandler mhandler = new MojarEventHandler();
        MinecraftForge.EVENT_BUS.register(mhandler);
        MinecraftForge.TERRAIN_GEN_BUS.register(mhandler);

        this.addBlocks();
        this.addItems();
        this.addDimension();
    }

    @Mod.EventHandler
    public void fmlLifeCycle(FMLPostInitializationEvent event){

    }

    private void addBlocks(){
        new MyBlock();
    }

    public void addItems(){
        new MojarTestItem();
        new MojarBow();
    }

    public void addDimension(){
        Biome mojar = new BiomeMojar();
        Biome.registerBiome(40, DimensionInfo.BIOME_NAME, mojar);

        WorldTypeMojar.addWorldType();
        Dimension.registerDimension();
    }
}
