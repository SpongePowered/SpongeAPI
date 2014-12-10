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

import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.service.persistence.serialization.DataSerializable;
import org.spongepowered.api.service.persistence.serialization.SerializableAs;

/**
 * Represents a possible Potion Effect.
 */
@SerializableAs(key = "PotionEffect")
public interface PotionEffect extends DataSerializable {

    /**
     * Gets the {@link PotionEffectType} of this potion.
     *
     * @return The type.
     */
    PotionEffectType getType();

    /**
     * Applies this potion effect to the specified
     * {@link Living}.
     *
     * @param ent The entity to apply the effect to.
     */
    void apply(Living ent);

    /**
     * Gets the duration for which this potion effect
     * will apply for.
     *
     * @return The duration.
     */
    int getDuration();

    /**
     * Sets the duration for which this potion effect
     * will apply for.
     *
     * @param duration The new duration.
     */
    void setDuration(int duration);

    /**
     * Gets the amplifier at which this potion effect
     * will apply effects.
     *
     * @return The amplifier.
     */
    int getAmplifier();

    /**
     * Sets the amplifier at which this potion effect
     * will apply effects.
     *
     * @param amplifier The new amplifier.
     */
    void setAmplifier(int amplifier);

    /**
     * Gets if the potion effect is an ambient effect.
     *
     * @return Gets if ambient.
     */
    boolean isAmbient();

    /**
     * Sets if the potion effect is an ambient effect.
     *
     * @param ambient New ambient value.
     */
    void setAmbient(boolean ambient);

    /**
     * Gets whether or not this potion effect should
     * show particles.
     *
     * @return If particles should be shown.
     */
    boolean getShowParticles();

    /**
     * Sets whether or not this potion effect should
     * show particles.
     *
     * @param showParticles If particles should be shown.
     */
    void setShowParticles(boolean showParticles);
}
