/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.util.event.Cancellable;

import java.util.Collection;

/**
 * An event when an {@link Entity} gains or removes a {@link PotionEffect}.
 *
 * <p>If the potion effect is being lost, {@link #setPotionEffect(PotionEffect)}
 * will have no change to the potion effect being removed. If a potion
 * effect is being removed due to expiration, cancelling the event will
 * have no change.</p>
 */
public interface EntityPotionEffectChangeEvent extends EntityEvent, CauseTracked, Cancellable {

    /**
     * Gets the {@link PotionEffect} being added or removed.
     *
     * @return The potion effect
     */
    PotionEffect getPotionEffect();

    /**
     * Gets whether the entity is gaining the linked {@link PotionEffect}.
     *
     * <p>If the potion effect is being lost, {@link #setPotionEffect(PotionEffect)}
     * will have no change to the potion effect being removed. If a potion
     * effect is being removed due to expiration, cancelling the event will
     * have no change.</p>
     *
     * @return If the potion effect is being added
     */
    boolean isBeingAdded();

    /**
     * Sets the potion effect to be added to the entity.
     *
     * <p>Setting the potion effect only changes the potion effect if the
     * effect is being added, a check for {@link #isBeingAdded()} is recommended.
     * </p>
     *
     * <p>If the potion effect is being lost, setting the {@link PotionEffect}
     * will have no change to the potion effect being removed. If a potion
     * effect is being removed due to expiration, cancelling the event will
     * have no change.</p>
     *
     * @param potionEffect The potion effect to add
     */
    void setPotionEffect(PotionEffect potionEffect);

    /**
     * Gets a copy of all currently active {@link PotionEffect}s on the entity.
     *
     * @return A copy of all potion effects active on the entity
     */
    Collection<PotionEffect> getCurrentEffects();

}
