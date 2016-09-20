package ru.mojar.rem.tz.core.modification;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class MojarEventHandler {

    //показывает приветственное сообщение
    @SubscribeEvent
    public void disclaimer(PlayerLoggedInEvent event){
        event.player.addChatComponentMessage(new TextComponentString("§cThis mod for internal use only!"));
        event.player.addChatComponentMessage(new TextComponentString("§cMod contains lots of bugs and glitches!"));
    }
}
