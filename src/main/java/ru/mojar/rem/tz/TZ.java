package ru.mojar.rem.tz;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.mojar.rem.tz.blocks.MyBlock;
import ru.mojar.rem.tz.items.MojarBow;
import ru.mojar.rem.tz.items.MojarTestItem;
import ru.mojar.rem.tz.other.ModInfo;
import ru.mojar.rem.tz.other.MojarEventHandler;
import ru.mojar.rem.tz.web.CommonProxy;

@Mod(modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION)
public class TZ {
    @Mod.Instance(ModInfo.MODID)
    public static TZ modIns;

    @SidedProxy(clientSide = "ru.mojar.rem.tz.web.ClientProxy", serverSide = "ru.mojar.rem.tz.web.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void fmlLifeCycle(FMLPreInitializationEvent event){
        modIns = this;
    }

    @Mod.EventHandler
    public void fmlLifeCycle(FMLInitializationEvent event){
        MojarEventHandler eventHandler = new MojarEventHandler();
        MinecraftForge.EVENT_BUS.register(eventHandler);

        this.addBlocks();
        this.addItems();
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
}
