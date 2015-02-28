package org.spongepowered.api.item.data;

import org.spongepowered.api.item.meta.FireworkExplosion;


public interface FireworkStar extends ItemData {

    FireworkExplosion getExplosion();

    void setExplosion(FireworkExplosion explosion);

}
