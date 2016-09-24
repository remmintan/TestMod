package ru.mojar.rem.tz;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.mojar.rem.tz.blocks.MyBlock;
import ru.mojar.rem.tz.blocks.MyBlockWorldGen;
import ru.mojar.rem.tz.other.MojarEventHandler;
import ru.mojar.rem.tz.items.MyItem;

@Mod(modid = TZ.MODID, name = TZ.MODNAME, version = TZ.VERSION)
public class TZ {

    public static final String MODID = "mojartz";
    public static final String MODNAME = "MoJar Teh. Zadanie";
    public static final String VERSION = "1.0.0";

    @Mod.EventHandler
    public void init (FMLInitializationEvent event){
        //более правильный способ регистрировать события. в предлыдущем моде, был способ @Deprecated
        MojarEventHandler eventHandler = new MojarEventHandler();
        MinecraftForge.EVENT_BUS.register(eventHandler);

        this.addBlock(); //добавление блока
        this.addItem();
    }

    //Для удобства создал отделную функцию, котрая регистрирует блок
    private void addBlock(){
        //Создается инстанс для блока и блок итема. Блок итем служит для отображения блока в инвентаре.
        MyBlock mojarBlock = new MyBlock();
        ItemBlock mojarItem = new ItemBlock(mojarBlock);
        mojarItem.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        //регистрируеца меш для отображения в инвентаре
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(mojarItem, 0, new ModelResourceLocation(MODID+":"+mojarBlock.getUnlocalizedName().substring(5), "inventory"));

        GameRegistry.register(mojarBlock.setRegistryName(mojarBlock.getUnlocalizedName().substring(5))); //название совпадается с UnlocalizedName. хз почему, но по другому не работает. позднее разберусь
        GameRegistry.register(mojarItem.setRegistryName(mojarBlock.getRegistryName()));

        MyBlockWorldGen generator = new MyBlockWorldGen(mojarBlock);
        GameRegistry.registerWorldGenerator(generator, 0);

        //сха построениея рецепта в првых трех кавычках указаны блоки которые должны быть выставлены на верстак
        //в данном случае
        //###
        //###
        //###
        GameRegistry.addRecipe(new ItemStack(mojarItem), "###","###", "###", '#', Blocks.GOLD_BLOCK);
    }

    public void addItem(){
        MyItem mojarItem = new MyItem();

        GameRegistry.register(mojarItem.setRegistryName(mojarItem.getUnlocalizedName().substring(5)));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(mojarItem, 0, new ModelResourceLocation(MODID+":"+mojarItem.getUnlocalizedName().substring(5), "inventory"));


    }
}
