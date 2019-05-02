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
package org.spongepowered.api.entity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.util.Color;

/**
 * Represents an AreaEffectCloud. The cloud will apply {@link PotionEffect}s to
 * {@link Entity} instances within it's bounding box.
 */
public interface AreaEffectCloud extends Entity {

    /**
     * Gets the {@link Color} of this cloud, can be changed.
     *
     * @return The color of this cloud
     */
    default Value.Mutable<Color> color() {
        return getValue(Keys.AREA_EFFECT_CLOUD_COLOR).get().asMutable();
    }

    /**
     * Gets the {@code radius} value of this cloud.
     *
     * @return The radius value of this cloud
     */
    default BoundedValue.Mutable<Double> radius() {
        return getValue(Keys.AREA_EFFECT_CLOUD_RADIUS).get().asMutable();
    }

    /**
     * Gets the {@link ParticleType} of this cloud.
     *
     * @return The particle type of this cloud
     */
    default Value.Mutable<ParticleType> particleType() {
        return getValue(Keys.AREA_EFFECT_CLOUD_PARTICLE_TYPE).get().asMutable();
    }

    /**
     * Gets the bounded {@code duration} value of this cloud.
     *
     * @return The bounded duration value
     */
    default BoundedValue.Mutable<Integer> duration() {
        return getValue(Keys.AREA_EFFECT_CLOUD_DURATION).get().asMutable();
    }

    /**
     * Gets the bounded {@code waitTime} value of this cloud. The wait time
     * dictates how long until this cloud will affect {@link Entity} instances
     * with {@link PotionEffect}s.
     *
     * @return The bounded wait time value
     */
    default BoundedValue.Mutable<Integer> waitTime() {
        return getValue(Keys.AREA_EFFECT_CLOUD_WAIT_TIME).get().asMutable();
    }

    /**
     * Gets the bounded {@code radiusOnUse} value of this cloud. The radius is
     * reduced per {@link Entity} affected. Once the radius is {@code 0}, the
     * cloud dissipates.
     *
     * @return The bounded radius reduced on use value
     */
    default BoundedValue.Mutable<Double> radiusOnUse() {
        return getValue(Keys.AREA_EFFECT_CLOUD_RADIUS_ON_USE).get().asMutable();
    }

    /**
     * Gets the bounded {@code radiusPerTick} value of this cloud. The radius is
     * reduced per tick (so technically can be set to {@code 0} to have it
     * remain permanent until it's effects have been used up.
     *
     * @return The bounded radius reduction per tick value
     */
    default BoundedValue.Mutable<Double> radiusPerTick() {
        return getValue(Keys.AREA_EFFECT_CLOUD_RADIUS_PER_TICK).get().asMutable();
    }

    /**
     * Gets the bounded {@code durationOnUse} value of this cloud. The duration
     * on use is reduced for every time that this cloud applies its
     * {@link PotionEffect}s on an {@link Entity}.
     *
     * @return The bounded duration on use value
     */
    default BoundedValue.Mutable<Integer> durationOnUse() {
        return getValue(Keys.AREA_EFFECT_CLOUD_DURATION_ON_USE).get().asMutable();
    }

    /**
     * Gets the bounded {@code applicationDelay} value of this cloud. What this
     * means is the application delay between times of application on an
     * {@link Entity}.
     *
     * @return The bounded re-application delay value
     */
    default BoundedValue.Mutable<Integer> applicationDelay() {
        return getValue(Keys.AREA_EFFECT_CLOUD_REAPPLICATION_DELAY).get().asMutable();
    }

    /**
     * Gets the {@link ListValue.Mutable} of {@link PotionEffect}s of this cloud. The
     * potion effects will affect any {@link Entity} according to the various
     * delays and ticks remaining of this cloud.
     *
     * @return The list of potion effects
     */
    default ListValue.Mutable<PotionEffect> effects() {
        return getValue(Keys.POTION_EFFECTS).get().asMutable();
    }

    /**
     * Gets the bounded {@code age} value of this cloud.
     *
     * @return The bounded age value
     */
    default BoundedValue.Mutable<Integer> age() {
        return getValue(Keys.AREA_EFFECT_CLOUD_AGE).get().asMutable();
    }

}
