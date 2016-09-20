package ru.mojar.rem.tz.core.modification;

import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.Method;

public class BowModifier {

    public static void checkName(){
        //useless shit!
        //wil be removed!
        Method bowGetDuration = ReflectionHelper.findMethod(ItemBow.class, Items.BOW, new String[] {"getMaxItemUseDuration"}, new Class[] {ItemStack.class});
        System.out.println(bowGetDuration.getName());

    }

}
