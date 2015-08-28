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
package org.spongepowered.api.event.target.entity;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.potion.PotionEffect;

/**
 * An event that involves a living entity having effects added and removed.
 */
public interface ChangeEntityPotionEffectEvent extends TargetEntityEvent, CauseTracked {

    /**
     * Gets a copy of all current effects applied on the entity.
     *
     * @return A copy of the potion effects
     */
    ImmutableList<PotionEffect> getCurrentEffects();

    /**
     * Gets the potion effect involved in this event.
     *
     * @return The potion effect involved in this event
     */
    PotionEffect getPotionEffect();

    interface Gain extends ChangeEntityPotionEffectEvent { }

    interface Remove extends ChangeEntityPotionEffectEvent { }

    interface Expire extends ChangeEntityPotionEffectEvent { }
}
