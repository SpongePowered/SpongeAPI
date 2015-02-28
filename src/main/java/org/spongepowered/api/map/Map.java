package org.spongepowered.api.map;

import org.spongepowered.api.world.Dimension;

import com.flowpowered.math.vector.Vector2i;
import com.google.common.base.Optional;

import javax.annotation.Nullable;


public interface Map {

    int getId();

    int getScale();

    void setScale(int scale);

    int getHeight();

    int getWidth();

    MapPixel getPixel(int x, int y);

    void setPixel(MapPixel pixel, int x, int y);

    Vector2i getCenter();

    void setCenter(Vector2i center);

    Optional<Dimension> getDimension();

    void setDimension(@Nullable Dimension dimension);
}
