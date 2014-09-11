/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.entity;

import org.spongepowered.api.effect.potion.EffectType;
import org.spongepowered.api.effect.potion.PotionEffect;

import javax.annotation.Nullable;
import java.util.Collection;

public interface LivingEntity extends Entity, Damageable {

    /**
     * adds a potion
     * if the effect type already exists, the old one is replaced by the new one
     *
     * @param effect {@link org.spongepowered.api.effect.potion.EffectType}
     * @param duration The duration of the effect in ticks (1/20 sec)
     * @param power The power of the effect
     * @param particles Whether visible particles will spawn around the entity
     */
    void applyPotionEffect(EffectType effect, int duration, int power, boolean particles);

    /**
     * Gets an {@link org.spongepowered.api.effect.potion.PotionEffect} by its effect type.
     * @param effect The effect to look up
     * @return The potion effect or null if not found
     */
    @Nullable
    PotionEffect getActivePotionEffect(EffectType effect);

    /**
     * remove all effects with target type
     *
     * @param effectType {@link org.spongepowered.api.effect.potion.EffectType}
     */
    void removePotionEffect(EffectType effectType);

    /**
     * Gets a {@link java.util.Collection} of all applied {@link org.spongepowered.api.effect.potion.PotionEffect}
     *
     * returns The active potion effects
     */
    Collection<PotionEffect> getActivePotionEffects();

    /**
     * removes all applied potion effects
     */
    void removeAllPotionEffects();
}
