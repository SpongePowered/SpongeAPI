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
import org.spongepowered.api.data.manipulator.mutable.entity.DamageableData;
import org.spongepowered.api.data.value.immutable.ImmutableOptionalValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.living.Living;

import java.util.Optional;

/**
 * An {@link ImmutableDataManipulator} for retaining the last known "attacker"
 * for an {@link Entity}. If there is no known last attacker, the
 * {@link #lastAttacker()} may have an {@link Optional#EMPTY} value.
 *
 * <p>This data will usually only stay around for 100 ticks, which is generally
 * around 5 or so seconds.</p>
 */
public interface ImmutableDamageableData extends ImmutableDataManipulator<ImmutableDamageableData, DamageableData> {

    /**
     * Gets the {@link ImmutableOptionalValue} for the last attacker.
     *
     * <p>This will usually be an entity snapshot of a {@link Living}.</p>
     *
     * <p>This data will usually only be present within 100 ticks of the attack
     * occurring.</p>
     *
     * @return The last attacker as an optional value
     */
    ImmutableOptionalValue<EntitySnapshot> lastAttacker();

    /**
     * Gets the last amount of damage taken by this entity as an optional value.
     *
     * <p>This data will usually only be present within 100 ticks of the attack
     * occurring.</p>
     *
     * @return The last damage dealt as an optional value
     */
    ImmutableOptionalValue<Double> lastDamage();

}
