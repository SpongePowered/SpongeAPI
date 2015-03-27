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

package org.spongepowered.api.potion;

import org.spongepowered.api.attribute.AttributeSource;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.service.persistence.DataSerializable;

/**
 * Represents a possible Potion Effect.
 *
 * <p>PotionEffects can be added to {@link Living} entities via
 * {@link Living#addPotionEffect(PotionEffect, boolean)}.</p>
 */
public interface PotionEffect extends DataSerializable, AttributeSource {

    /**
     * Gets the {@link PotionEffectType} of this potion.
     *
     * @return The type.
     */
    PotionEffectType getType();

    /**
     * Gets the duration for which this potion effect
     * will apply for.
     *
     * @return The duration.
     */
    int getDuration();

    /**
     * Gets the amplifier at which this potion effect
     * will apply effects.
     *
     * @return The amplifier.
     */
    int getAmplifier();

    /**
     * Gets if the potion effect is an ambient effect.
     *
     * @return Gets if ambient.
     */
    boolean isAmbient();

    /**
     * Gets whether or not this potion effect should
     * show particles.
     *
     * @return If particles should be shown.
     */
    boolean getShowParticles();

}
