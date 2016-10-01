package ru.mojar.rem.tz.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.mojar.rem.tz.other.ModInfo;

public class ItemManager {

    public static void registerItems(){
        Item test = new MojarTestItem();
        registerItem(test);

        Item newBow = new MojarBow();
        registerItem(newBow);
    }

    private static void registerItem(Item item){
        item.setRegistryName(ModInfo.MODID+":"+item.getUnlocalizedName().substring(5));

        GameRegistry.register(item);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModInfo.MODID+":"+item.getUnlocalizedName().substring(5), "inventory"));
    }

}
