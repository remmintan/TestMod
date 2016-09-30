package ru.mojar.rem.tz.mobs.Render;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import ru.mojar.rem.tz.mobs.MojarMob;
import ru.mojar.rem.tz.mobs.Render.models.MojarMobModel;
import ru.mojar.rem.tz.other.ModInfo;

public class RenderMojarMob extends RenderBiped<MojarMob>{

    private static final ResourceLocation REMMINTAN_TEXTURE1 = new ResourceLocation(ModInfo.MODID, "textures/entity/rem1.png");
    private static final ResourceLocation REMMINTAN_TEXTURE2 = new ResourceLocation(ModInfo.MODID, "textures/entity/rem2.png");

    private final boolean isRed;

    public RenderMojarMob(RenderManager renderManagerIn, boolean isRed) {
        super(renderManagerIn, new MojarMobModel(), 0.5F, 1.0F);

        this.isRed = isRed;

        this.addLayer(new LayerHeldItem(this));
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new MojarMobModel(0.5F, true);
                this.modelArmor = new MojarMobModel(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);
    }

    @Override
    protected ResourceLocation getEntityTexture(MojarMob ent){
        if(isRed)
            return REMMINTAN_TEXTURE1;
        else
            return REMMINTAN_TEXTURE2;
    }
}
