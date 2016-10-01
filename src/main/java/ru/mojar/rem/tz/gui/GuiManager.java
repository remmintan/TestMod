package ru.mojar.rem.tz.gui;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import ru.mojar.rem.tz.TZ;

public class GuiManager {

    public static void registerGuis(){
        NetworkRegistry.INSTANCE.registerGuiHandler(TZ.modIns, new MojarGuiHandler());
    }

}
