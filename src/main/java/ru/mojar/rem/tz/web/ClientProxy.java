package ru.mojar.rem.tz.web;


import net.minecraftforge.fml.client.registry.RenderingRegistry;
import ru.mojar.rem.tz.mobs.MojarBlue;
import ru.mojar.rem.tz.mobs.MojarRed;
import ru.mojar.rem.tz.mobs.Render.RenderMojar;

/**
 * Создан для деления пакетов на клиентские и серверные
 */
public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(MojarRed.class, new RenderMojar(true));
        RenderingRegistry.registerEntityRenderingHandler(MojarBlue.class, new RenderMojar(false));
    }

    @Override
    public void registerKeyBindings(){

    }

}
