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
package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableAreaEffectCloudData;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.Color;

public interface AreaEffectCloudData extends DataManipulator<AreaEffectCloudData, ImmutableAreaEffectCloudData> {

    /**
     * Gets the {@link Color} of this cloud, can be changed.
     *
     * @return The color of this cloud
     * @see Keys#AREA_EFFECT_CLOUD_COLOR
     */
    Value<Color> color();

    /**
     * Gets the {@code radius} value of this cloud.
     *
     * @return The radius value of this cloud
     * @see Keys#AREA_EFFECT_CLOUD_RADIUS
     */
    MutableBoundedValue<Double> radius();

    /**
     * Gets the {@link ParticleType} of this cloud.
     *
     * @return The particle type of this cloud
     * @see Keys#AREA_EFFECT_CLOUD_PARTICLE_TYPE
     */
    Value<ParticleType> particleType();

    /**
     * Gets the bounded {@code duration} value of this cloud.
     *
     * @return The bounded duration value
     * @see Keys#AREA_EFFECT_CLOUD_DURATION
     */
    MutableBoundedValue<Integer> duration();

    /**
     * Gets the bounded {@code waitTime} value of this cloud. The wait time
     * dictates how long until this cloud will affect {@link Entity} instances
     * with {@link PotionEffect}s.
     *
     * @return The bounded wait time value
     * @see Keys#AREA_EFFECT_CLOUD_WAIT_TIME
     */
    MutableBoundedValue<Integer> waitTime();

    /**
     * Gets the bounded {@code radiusOnUse} value of this cloud.
     * The radius is modified per {@link Entity} affected.
     * Once the radius is {@code 0}, the cloud dissipates.
     * <p>A positive radiusOnUse value will make the cloud grow, a negative
     * one will make it shrink.</p>
     *
     * @return The bounded radius reduced on use value
     * @see Keys#AREA_EFFECT_CLOUD_RADIUS_ON_USE
     */
    MutableBoundedValue<Double> radiusOnUse();

    /**
     * Gets the bounded {@code radiusPerTick} value of this cloud.
     *
     * <p>The radius is increased every tick. A radiusPerTick of 0 will cause
     * the cloud to stay at its original size until its duration runs out, a
     * positive number will make it grow, and a negative number will make it
     * shrink whenever it applies its effect.
     *
     * @return The bounded radius reduction per tick value
     * @see Keys#AREA_EFFECT_CLOUD_RADIUS_PER_TICK
     */
    MutableBoundedValue<Double> radiusPerTick();

    /**
     * Gets the bounded {@code durationOnUse} value of this cloud.
     * The duration on use is added to the duration for every time
     * that this cloud applies it's {@link PotionEffect}s on an
     * {@link Entity}.
     *  <p>If the duration on use is negative, every application of
     *  an effect to an entity will decrease the cloud's duration</p>
     *
     * @return The bounded duration on use value
     * @see Keys#AREA_EFFECT_CLOUD_DURATION_ON_USE
     */
    MutableBoundedValue<Integer> durationOnUse();

    /**
     * Gets the bounded {@code applicationDelay} value of this cloud.
     * What this means is the application delay between times of application
     * on an {@link Entity}.
     *
     * @return The bounded re-application delay value
     * @see Keys#AREA_EFFECT_CLOUD_REAPPLICATION_DELAY
     */
    MutableBoundedValue<Integer> applicationDelay();

    /**
     * Gets the {@link ListValue} of {@link PotionEffect}s of this cloud.
     * The potion effects will affect any {@link Entity} according to the
     * various delays and ticks remaining of this cloud.
     *
     * @return The list of potion effects
     * @see Keys#POTION_EFFECTS
     */
    ListValue<PotionEffect> effects();

    /**
     * Gets the bounded {@code age} value of this cloud.
     *
     * @return The bounded age value
     * @see Keys#AREA_EFFECT_CLOUD_AGE
     */
    MutableBoundedValue<Integer> age();

}
