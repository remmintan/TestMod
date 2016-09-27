package ru.mojar.rem.tz.generator;

import net.minecraft.world.WorldType;

public class WorldTypeMojar extends WorldType {

    public static WorldTypeMojar wt;

    public WorldTypeMojar(String name) {
        super(name);
    }

    public static void addWorldType(){
        wt = new WorldTypeMojar(DimensionInfo.WORLD_TYPE_NAME);
    }
}
