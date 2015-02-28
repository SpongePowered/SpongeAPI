package org.spongepowered.api.item.data;

import org.spongepowered.api.potion.PotionEffect;

import java.util.Set;

public interface Potion extends ItemData {

    Set<PotionEffect> getEffects();

    void addEffect(PotionEffect effect);

    void removeEffect(PotionEffect effect);

}
