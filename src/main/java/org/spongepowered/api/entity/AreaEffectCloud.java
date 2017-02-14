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
import org.spongepowered.api.data.manipulator.mutable.entity.AreaEffectCloudData;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.util.Color;

/**
 * Represents an AreaEffectCloud. The cloud will apply {@link PotionEffect}s to
 * {@link Entity} instances within it's bounding box.
 */
public interface AreaEffectCloud extends Entity {

    /**
     * Gets the {@link AreaEffectCloudData} for this cloud.
     *
     * @return The area effect cloud data
     */
    default AreaEffectCloudData getAreaEffectCloudData() {
        return get(AreaEffectCloudData.class).get();
    }

    /**
     * Gets the {@link Color} of this cloud, can be changed.
     *
     * @return The color of this cloud
     */
    default Value<Color> color() {
        return getValue(Keys.AREA_EFFECT_CLOUD_COLOR).get();
    }

    /**
     * Gets the {@code radius} value of this cloud.
     *
     * @return The radius value of this cloud
     */
    default MutableBoundedValue<Double> radius() {
        return getValue(Keys.AREA_EFFECT_CLOUD_RADIUS).get();
    }

    /**
     * Gets the {@link ParticleType} of this cloud.
     *
     * @return The particle type of this cloud
     */
    default Value<ParticleType> particleType() {
        return getValue(Keys.AREA_EFFECT_CLOUD_PARTICLE_TYPE).get();
    }

    /**
     * Gets the bounded {@code duration} value of this cloud.
     *
     * @return The bounded duration value
     */
    default MutableBoundedValue<Integer> duration() {
        return getValue(Keys.AREA_EFFECT_CLOUD_DURATION).get();
    }

    /**
     * Gets the bounded {@code waitTime} value of this cloud. The wait time
     * dictates how long until this cloud will affect {@link Entity} instances
     * with {@link PotionEffect}s.
     *
     * @return The bounded wait time value
     */
    default MutableBoundedValue<Integer> waitTime() {
        return getValue(Keys.AREA_EFFECT_CLOUD_WAIT_TIME).get();
    }

    /**
     * Gets the bounded {@code radiusOnUse} value of this cloud. The radius is
     * reduced per {@link Entity} affected. Once the radius is {@code 0}, the
     * cloud dissipates.
     *
     * @return The bounded radius reduced on use value
     */
    default MutableBoundedValue<Double> radiusOnUse() {
        return getValue(Keys.AREA_EFFECT_CLOUD_RADIUS_ON_USE).get();
    }

    /**
     * Gets the bounded {@code radiusPerTick} value of this cloud. The radius is
     * reduced per tick (so technically can be set to {@code 0} to have it
     * remain permanent until it's effects have been used up.
     *
     * @return The bounded radius reduction per tick value
     */
    default MutableBoundedValue<Double> radiusPerTick() {
        return getValue(Keys.AREA_EFFECT_CLOUD_RADIUS_PER_TICK).get();
    }

    /**
     * Gets the bounded {@code durationOnUse} value of this cloud. The duration
     * on use is reduced for every time that this cloud applies its
     * {@link PotionEffect}s on an {@link Entity}.
     *
     * @return The bounded duration on use value
     */
    default MutableBoundedValue<Integer> durationOnUse() {
        return getValue(Keys.AREA_EFFECT_CLOUD_DURATION_ON_USE).get();
    }

    /**
     * Gets the bounded {@code applicationDelay} value of this cloud. What this
     * means is the application delay between times of application on an
     * {@link Entity}.
     *
     * @return The bounded re-application delay value
     */
    default MutableBoundedValue<Integer> applicationDelay() {
        return getValue(Keys.AREA_EFFECT_CLOUD_REAPPLICATION_DELAY).get();
    }

    /**
     * Gets the {@link ListValue} of {@link PotionEffect}s of this cloud. The
     * potion effects will affect any {@link Entity} according to the various
     * delays and ticks remaining of this cloud.
     *
     * @return The list of potion effects
     */
    default ListValue<PotionEffect> effects() {
        return getValue(Keys.POTION_EFFECTS).get();
    }

    /**
     * Gets the bounded {@code age} value of this cloud.
     *
     * @return The bounded age value
     */
    default MutableBoundedValue<Integer> age() {
        return getValue(Keys.AREA_EFFECT_CLOUD_AGE).get();
    }

}
