package ru.mojar.rem.tz.mobs;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import ru.mojar.rem.tz.TZ;
import ru.mojar.rem.tz.mobs.AI.EntityAIPigAttack;

import java.util.Random;

public class MobManager {

    public static void registrEntities(){
        MobManager.registerEntity(MojarMob.class, "mojar_mob", 121, 10, 3);
    }

    public static void entitySpawn(EntityLiving ent){
        if(ent instanceof EntityPig)
            taskStuff((EntityPig) ent);

    }

    private static void taskStuff(EntityPig ent){
        IAttributeInstance attIns = ent.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        if(attIns == null){
            ent.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
            ent.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0f);
        }
        else
            attIns.setBaseValue(4.0f);

        ent.targetTasks.addTask(1, new EntityAINearestAttackableTarget(ent, EntityPlayer.class, true));
        ent.tasks.addTask(1, new EntityAIPigAttack(ent, 1.0, true));
    }

    //удаляет вообще всю логику поведения
    private static void becomeStupid(EntityLiving ent){
        for(Object o:ent.tasks.taskEntries.toArray()){
            EntityAIBase ai = ((EntityAITasks.EntityAITaskEntry)o).action;
            ent.tasks.removeTask(ai);
        }
        for(Object o:ent.targetTasks.taskEntries.toArray()){
            EntityAIBase ai  = ((EntityAITasks.EntityAITaskEntry)o).action;
            ent.tasks.removeTask(ai);
        }
    }

    private static void registerEntity(Class entityClass, String name, int id, int trackingRange, int updateFrequensy)
    {

        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;


        EntityRegistry.registerModEntity(entityClass, name, id, TZ.modIns, trackingRange, updateFrequensy, false, primaryColor, secondaryColor);


    }

}
