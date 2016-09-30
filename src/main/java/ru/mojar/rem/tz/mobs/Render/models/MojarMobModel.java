package ru.mojar.rem.tz.mobs.Render.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class MojarMobModel extends ModelBiped{



    public MojarMobModel(){
        this(0f, false);
    }

    public MojarMobModel(float modelSize, boolean p_i1168_2_)
    {
        super(modelSize, 0.0F, 64, p_i1168_2_ ? 32 : 64);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

    }


}
