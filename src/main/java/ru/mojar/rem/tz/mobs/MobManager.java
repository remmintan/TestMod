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

    /**
     * Говорит за себя.
     * Статический метод вызывается из главного класса мода и регистрирует мобов.
     */
    public static void registrEntities(){
        MobManager.registerEntity(MojarRed.class, "mojar_red", 121);
        MobManager.registerEntity(MojarBlue.class, "mojar_blue", 122);
    }

    /**
     * Данный метод вызывается из Event Handler'a
     * Вызывается каждый раз, когда существо (EntityLiving) появляется в мире
     * @param ent ссылка на существо, которое заспаунилось в мире
     */
    public static void entitySpawn(EntityLiving ent){
        //just do nothing
        //TODO fix bug with Attack Damage!
    }

    /**
     * Метод для экспериментов над свиньей. Покачто успехом не увечался
     * @param ent ссылка на свинью
     */
    private static void taskStuff(EntityPig ent){
        IAttributeInstance attIns = ent.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        if(attIns == null){
            ent.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE); //это дерьмо почему-то не работает. Нужен FIX
            ent.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0f);
        }
        else
            attIns.setBaseValue(4.0f);

        ent.targetTasks.addTask(1, new EntityAINearestAttackableTarget(ent, EntityPlayer.class, true));
        ent.tasks.addTask(1, new EntityAIPigAttack(ent, 1.0, true));
    }

    /**
     * Удаляет всю лоигку поведения, существо перестает вообще как либо проявлять себя. Тупо стоит.
     * Метод используется для дебага
     * @param ent ссыдка на существо
     */
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

    /**
     * Регистрирует конкретного моба
     * @param entityClass класс моба
     * @param name имя, которое игра будет использовать для итендификации моба
     * @param id итендификатор в EntityRegistry (лучше погуглить незанятые id)
     */
    private static void registerEntity(Class entityClass, String name, int id)
    {

        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        //tracking range and update frequensy are random! :)
        EntityRegistry.registerModEntity(entityClass, name, id, TZ.modIns, 80, 3, false, primaryColor, secondaryColor);
    }

}
