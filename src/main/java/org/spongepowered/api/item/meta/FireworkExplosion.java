package org.spongepowered.api.item.meta;

import java.awt.Color;
import java.util.List;


public interface FireworkExplosion {

    boolean doesFlicker();

    void setFlickers(boolean flickers);

    boolean hasTrail();

    void setHasTrail(boolean trail);

    List<Color> getColors();

    void addColor(Color color);

    List<Color> getFadeColors();

    void addFadeColor(Color color);

    FireworkShape getShape();

    void setShape(FireworkShape shape);

}
