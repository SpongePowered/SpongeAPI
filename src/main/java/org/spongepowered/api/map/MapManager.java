package org.spongepowered.api.map;

import org.spongepowered.api.block.BlockState;

import java.awt.Color;
import java.awt.image.BufferedImage;

public interface MapManager {

    int getMaps();

    int allocateNewMap() throws IllegalStateException;

    void deallocateMap(int id);

    Map getMap(int id);

    int[] getAllocatedIds();

    void importImage(Map map, BufferedImage image);

    MapPixel getClosestPixel(Color color);

    int getMaximumMaps();

    MapColor getColor(BlockState state);

}
