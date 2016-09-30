package ru.mojar.rem.tz.mobs.Render;

import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMojar implements IRenderFactory {

    private final boolean isRed;
    public RenderMojar(boolean isRed){
        this.isRed = isRed;
    }


    @Override
    public Render createRenderFor(RenderManager manager) {
        return new RenderMojarMob(manager, isRed);
    }
}
