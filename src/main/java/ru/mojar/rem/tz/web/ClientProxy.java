package ru.mojar.rem.tz.web;


import net.minecraftforge.fml.client.registry.RenderingRegistry;
import ru.mojar.rem.tz.mobs.Render.RenderMojar;
import ru.mojar.rem.tz.mobs.MojarMob;

/**
 * Создан для деления пакетов на клиентские и серверные
 */
public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenderers(){
        RenderingRegistry.registerEntityRenderingHandler(MojarMob.class, new RenderMojar());
    }

    @Override
    public void registerKeyBindings(){

    }

}
