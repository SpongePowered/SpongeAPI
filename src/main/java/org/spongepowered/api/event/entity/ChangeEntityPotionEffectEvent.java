/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;

import java.util.List;

/**
 * An event that involves a living entity having effects added and removed.
 */
public interface ChangeEntityPotionEffectEvent extends Event, Cancellable {

    /**
     * Gets the {@link Entity}.
     *
     * @return The entity
     */
    Entity getEntity();

    /**
     * Gets a copy of all current effects applied on the entity.
     *
     * @return A copy of the potion effects
     */
    List<PotionEffect> getCurrentEffects();

    /**
     * Gets the potion effect involved in this event.
     *
     * @return The potion effect involved in this event
     */
    PotionEffect getPotionEffect();

    /**
     * An event where the {@link PotionEffect} is being added.
     */
    interface Gain extends ChangeEntityPotionEffectEvent {
        
        /**
         * Gets the original potion effect involved in this event.
         *
         * @return The original potion effect involved in this event
         */
        PotionEffect getOriginalPotionEffect();
        
        /**
         * Sets the potion effect to be used in this event.
         *
         * @param effect The potion effect to be used in this event
         */
        void setPotionEffect(PotionEffect effect);
    }

    /**
     * An event where the {@link PotionEffect} is being removed.
     */
    interface Remove extends ChangeEntityPotionEffectEvent { }

    /**
     * An event where the {@link PotionEffect} is forcibly expiring.
     */
    interface Expire extends ChangeEntityPotionEffectEvent { }
}
