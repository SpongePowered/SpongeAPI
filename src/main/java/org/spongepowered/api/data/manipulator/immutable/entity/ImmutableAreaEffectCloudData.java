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
package org.spongepowered.api.data.manipulator.immutable.entity;

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.AreaEffectCloudData;
import org.spongepowered.api.data.value.immutable.ImmutableBoundedValue;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.Color;

public interface ImmutableAreaEffectCloudData extends ImmutableDataManipulator<ImmutableAreaEffectCloudData, AreaEffectCloudData> {

    /**
     * Gets the {@link Color} of this cloud, can be changed.
     *
     * @return The color of this cloud
     */
    ImmutableValue<Color> color();

    /**
     * Gets the {@code radius} value of this cloud.
     *
     * @return The radius value of this cloud
     */
    ImmutableBoundedValue<Double> radius();

    /**
     * Gets the {@link ParticleType} of this cloud.
     *
     * @return The particle type of this cloud
     */
    ImmutableValue<ParticleType> particleType();

    /**
     * Gets the bounded {@code duration} value of this cloud.
     *
     * @return The bounded duration value
     */
    ImmutableBoundedValue<Integer> duration();

    /**
     * Gets the bounded {@code waitTime} value of this cloud. The wait time
     * dictates how long until this cloud will affect {@link Entity} instances
     * with {@link PotionEffect}s.
     *
     * @return The bounded wait time value
     */
    ImmutableBoundedValue<Integer> waitTime();

    /**
     * Gets the bounded {@code radiusOnUse} value of this cloud.
     * The radius is reduced per {@link Entity} affected.
     * Once the radius is {@code 0}, the cloud dissipates.
     *
     * @return The bounded radius reduced on use value
     */
    ImmutableBoundedValue<Double> radiusOnUse();

    /**
     * Gets the bounded {@code radiusPerTick} value of this cloud.
     * The radius is reduced per tick (so technically can be set to
     * {@code 0} to have it remain permanent until it's effects have
     * been used up.
     *
     * @return The bounded radius reduction per tick value
     */
    ImmutableBoundedValue<Double> radiusPerTick();

    /**
     * Gets the bounded {@code durationOnUse} value of this cloud.
     * The duration on use is reduced for every time that this cloud
     * applies it's {@link PotionEffect}s on an {@link Entity}.
     *
     * @return The bounded duration on use value
     */
    ImmutableBoundedValue<Integer> durationOnUse();

    /**
     * Gets the bounded {@code applicationDelay} value of this cloud.
     * What this means is the application delay between times of application
     * on an {@link Entity}.
     *
     * @return The bounded re-application delay value
     */
    ImmutableBoundedValue<Integer> applicationDelay();

    /**
     * Gets the {@link ListValue} of {@link PotionEffect}s of this cloud.
     * The potion effects will affect any {@link Entity} according to the
     * various delays and ticks remaining of this cloud.
     *
     * @return The list of potion effects
     */
    ImmutableListValue<PotionEffect> effects();

    /**
     * Gets the bounded {@code age} value of this cloud.
     *
     * @return The bounded age value
     */
    ImmutableBoundedValue<Integer> age();

}
