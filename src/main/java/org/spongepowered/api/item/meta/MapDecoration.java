package org.spongepowered.api.item.meta;

import com.flowpowered.math.vector.Vector2i;


public interface MapDecoration {

    MapDecorationType getType();
    
    void setType(MapDecorationType type);

    Vector2i getPosition();

    void setPosition(Vector2i position);

    int getRotation();

    void setRotation();
    
}
