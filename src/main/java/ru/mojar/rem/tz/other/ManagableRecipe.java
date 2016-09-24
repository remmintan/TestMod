package ru.mojar.rem.tz.other;

import com.sun.istack.internal.NotNull;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ManagableRecipe implements IRecipe{

    private final IRecipe baseRecipe;

    private ItemStack output = null;

    public ManagableRecipe(@NotNull IRecipe recp){
        this.baseRecipe = recp;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return this.baseRecipe.matches(inv, worldIn);
    }

    @Nullable
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        if(this.baseRecipe.getCraftingResult(inv) != null){
            return this.getRecipeOutput().copy();
        }
        return null;
    }

    @Override
    public int getRecipeSize() {
        return this.baseRecipe.getRecipeSize();
    }

    @Nullable
    @Override
    public ItemStack getRecipeOutput() {
        if(output == null){
            return this.baseRecipe.getRecipeOutput();
        }else{
            return this.output;
        }
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        return this.baseRecipe.getRemainingItems(inv);
    }
}
