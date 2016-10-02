package ru.mojar.rem.tz.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import ru.mojar.rem.tz.blocks.tile_entities.MojarTileEntitiy;

public class MojarGuiContainer extends GuiContainer {

    public MojarGuiContainer(IInventory playerInv, MojarTileEntitiy tileEnt) {
        super(new MojarContainer(playerInv, tileEnt));

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

    }
}
