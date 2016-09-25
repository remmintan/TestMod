package ru.mojar.rem.tz.other;

import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.Iterator;

public class Utilites {
    /**
     * Удаляет стандартный рецепт
     * @param item результат того рецепта, который нужно удалить
     * @return ссылка на удаленный рецепт
     */
    public static IRecipe removeRecipe(Item item){
        java.util.List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        Iterator<IRecipe> iter = recipes.iterator();
        while (iter.hasNext()){
            IRecipe recp = iter.next();

            if(recp.getRecipeOutput() != null && recp.getRecipeOutput().getItem() == item){
                recipes.remove(recp);
                System.out.println("[MOJAR] Recipe removed: "+recp.getRecipeOutput().getItem().getRegistryName());
                return recp;
            }
        }

        return null;
    }

    /**
     * Заменяет результат выполнения стандартного рецепта
     * @param oldR старый результат рецепта
     * @param newR новый результат рецепта
     */

    public static void changeRecipe(Item oldR, Item newR){
        IRecipe recp = removeRecipe(oldR);

        if(recp == null){
            System.out.println("[MOJAR] Can't find recipe!");
            return;
        }

        ManagableRecipe newRecp = new ManagableRecipe(recp);
        newRecp.setOutput(new ItemStack(newR));
        CraftingManager.getInstance().addRecipe(newRecp);
    }



}
