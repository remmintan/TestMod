package ru.mojar.rem.tz.mobs.AI;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.passive.EntityPig;

public class EntityAIPigAttack extends EntityAIAttackMelee {

    public EntityAIPigAttack(EntityPig creature, double speedIn, boolean useLongMemory) {
        super(creature, speedIn, useLongMemory);
    }

    protected double getAttackReachSqr(EntityLivingBase attackTarget)
    {
        return (double)(4.0F + attackTarget.width);
    }
}
