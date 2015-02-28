package org.spongepowered.api.item.data;

import org.spongepowered.api.item.meta.FireworkExplosion;

import java.util.Set;


public interface FireworkRocket extends ItemData {

    Set<FireworkExplosion> getExplosions();

    void addExplosion(FireworkExplosion explosion);

    int getFlightTime();

    void setFlightTime(int time);

}
