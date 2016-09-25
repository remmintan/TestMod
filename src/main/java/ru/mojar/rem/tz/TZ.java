package ru.mojar.rem.tz;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.mojar.rem.tz.blocks.MyBlock;
import ru.mojar.rem.tz.items.MojarBow;
import ru.mojar.rem.tz.items.MojarTestItem;
import ru.mojar.rem.tz.other.MojarEventHandler;
import ru.mojar.rem.tz.web.CommonProxy;

@Mod(modid = TZ.MODID, name = TZ.MODNAME, version = TZ.VERSION)
public class TZ {

    public static final String MODID = "mojartz";
    public static final String MODNAME = "MoJar Teh. Zadanie";
    public static final String VERSION = "1.0.0";

    @Mod.Instance("tz")
    public static TZ modIns;

    @SidedProxy(clientSide = "ru.mojar.rem.tz.web.ClientProxy", serverSide = "ru.mojar.rem.tz.web.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void fmlLifeCycle(FMLPreInitializationEvent event){
        modIns = this;

        //более правильный способ регистрировать события. в предлыдущем моде, был способ @Deprecated
        MojarEventHandler eventHandler = new MojarEventHandler();
        MinecraftForge.EVENT_BUS.register(eventHandler);
    }

    @Mod.EventHandler
    public void fmlLifeCycle(FMLInitializationEvent event){
        this.addBlocks();
        this.addItems();
    }

    //Для удобства создал отделную функцию, котрая регистрирует блок
    private void addBlocks(){
        new MyBlock();

    }

    public void addItems(){
        new MojarTestItem();
        new MojarBow();
    }
}
