package ru.mojar.rem.tz.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import ru.mojar.rem.tz.TZ;
import ru.mojar.rem.tz.blocks.tile_entities.MojarTileEntitiy;

public class MojarGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GuiManager.MOJAR_GUI_ID){
            System.out.println(TZ.DEBUG_PREFIX+"GUI HANDLED! SERVER");

            return new MojarContainer(player.inventory, (MojarTileEntitiy) world.getTileEntity(new BlockPos(x,y,z)));
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GuiManager.MOJAR_GUI_ID){
            System.out.println(TZ.DEBUG_PREFIX+"GUI HANDLED! CLIENT");

            return new MojarGuiContainer(player.inventory, (MojarTileEntitiy) world.getTileEntity(new BlockPos(x,y,z)));
        }

        return null;
    }
}
