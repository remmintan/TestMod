package ru.mojar.rem.tz.mobs;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.world.World;

public class MojarBlue extends MojarMob {

    public MojarBlue(World worldIn) {
        super(worldIn);
    }

    @Override
    public void initEntityAI(){
        super.initEntityAI();
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, MojarRed.class, true));
    }

}
