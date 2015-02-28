package org.spongepowered.api.item.data;

import org.spongepowered.api.item.meta.MapDecoration;

import java.util.List;

public interface MapItem extends ItemData {

    boolean isScaled();

    List<MapDecoration> getDecorations();

    void addDecoration(MapDecoration decoration);
}
