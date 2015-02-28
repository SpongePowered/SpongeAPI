package org.spongepowered.api.item.meta;

import java.awt.Color;
import java.util.List;


public interface FireworkExplosionBuilder {

    FireworkExplosionBuilder flicker(boolean flicker);

    FireworkExplosionBuilder trail(boolean trail);

    FireworkExplosionBuilder color(Color color);

    FireworkExplosionBuilder colors(List<Color> colors);

    FireworkExplosionBuilder fadeColor(Color color);

    FireworkExplosionBuilder fadeColors(List<Color> fadeColors);

    FireworkExplosionBuilder shape(FireworkShape shape);

    FireworkExplosion build();

}
