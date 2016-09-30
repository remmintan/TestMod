package ru.mojar.rem.tz.mobs.Render;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import ru.mojar.rem.tz.mobs.MojarMob;

public class RenderMojarMob extends RenderBiped<MojarMob>{

    public RenderMojarMob(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelZombie(), 0.5F, 1.0F);
    }
}
