package ru.mojar.rem.tz.other;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import ru.mojar.rem.tz.generator.BiomeMojar;
import ru.mojar.rem.tz.generator.MojarBiomeDecorator;

public class MojarEventHandler {


    @SubscribeEvent
    public void playerLogged(PlayerLoggedInEvent event){
        showDisclaimer(event.player);
    }

    @SubscribeEvent
    public void newDecorator(BiomeEvent.CreateDecorator event){

        if(event.getBiome().getBiomeClass() == BiomeMojar.class)
            event.setNewBiomeDecorator(new MojarBiomeDecorator());
    }

    //показывает приветственное сообщение
    private void showDisclaimer(EntityPlayer player){
        player.addChatComponentMessage(new TextComponentString("§cThis mod for internal use only!"));
        player.addChatComponentMessage(new TextComponentString("§cMod contains lots of bugs and glitches!"));
    }


}
