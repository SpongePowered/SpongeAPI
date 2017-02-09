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
import org.spongepowered.api.data.manipulator.mutable.entity.DamagingData;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.arrow.Arrow;

/**
 * A {@link ImmutableDataManipulator} for an owner that will deal a certain amount of
 * damage on the next "attack". Usually applicable to {@link Arrow}s and other
 * {@link Projectile}s.
 */
public interface ImmutableDamagingData extends ImmutableDataManipulator<ImmutableDamagingData, DamagingData> {

    /**
     * Gets the damage this projectile will deal to an {@link Entity} if hit.
     *
     * @return The damage to deal as a value
     */
    ImmutableValue<Double> damage();

    /**
     * Gets the {@link ImmutableMapValue} for representing the custom damage
     * values to use if the owner strikes an entity of that type.
     *
     * <p>Note that in events, the damage defined for the provided
     * {@link EntityType} will take priority over the "default" damage as
     * defined from {@link #damage()}.</p>
     *
     * @return The immutable map value for the entity damage values
     */
    ImmutableMapValue<EntityType, Double> damageForEntityTypes();

}
