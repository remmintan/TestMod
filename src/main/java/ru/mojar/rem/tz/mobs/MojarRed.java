package ru.mojar.rem.tz.mobs;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.world.World;

public class MojarRed extends MojarMob {

    public MojarRed(World worldIn) {
        super(worldIn);
    }

    @Override
    public void initEntityAI(){
        super.initEntityAI();
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, MojarBlue.class, false));
    }
}
