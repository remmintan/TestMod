package ru.mojar.rem.tz;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.mojar.rem.tz.blocks.BlockManager;
import ru.mojar.rem.tz.generator.DimensionManagerM;
import ru.mojar.rem.tz.gui.GuiManager;
import ru.mojar.rem.tz.items.ItemManager;
import ru.mojar.rem.tz.mobs.MobManager;
import ru.mojar.rem.tz.other.ModInfo;
import ru.mojar.rem.tz.other.MojarEventHandler;
import ru.mojar.rem.tz.web.CommonProxy;

@Mod(modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION)
public class TZ {

    public static final String DEBUG_PREFIX = "[MOJAR DEBUG]: ";

    @Mod.Instance(ModInfo.MODID)
    public static TZ modIns;

    @SidedProxy(clientSide = "ru.mojar.rem.tz.web.ClientProxy", serverSide = "ru.mojar.rem.tz.web.CommonProxy")
    private static CommonProxy proxy;

    @Mod.EventHandler
    public void fmlLifeCycle(FMLPreInitializationEvent event){
        modIns = this;

        MobManager.registrEntities();
        proxy.registerRenderers();
    }

    @Mod.EventHandler
    public void fmlLifeCycle(FMLInitializationEvent event){
        MojarEventHandler mhandler = new MojarEventHandler();
        MinecraftForge.EVENT_BUS.register(mhandler);
        MinecraftForge.TERRAIN_GEN_BUS.register(mhandler);

        GuiManager.registerGuis();
        BlockManager.ins.registerBlocks();
        ItemManager.registerItems();
        DimensionManagerM.registerDimensions();
    }

    @Mod.EventHandler
    public void fmlLifeCycle(FMLPostInitializationEvent event){
    }
}
