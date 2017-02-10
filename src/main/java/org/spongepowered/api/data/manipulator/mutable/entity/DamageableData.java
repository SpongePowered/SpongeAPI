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
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableDamageableData;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;

import java.util.Optional;

/**
 * A {@link DataManipulator} for retaining the last known "attacker" for an
 * {@link Entity}. Usually, the last attacker is known, however, due to
 * the lifetime of the game, the last attacker may "expire" or die, in which
 * case, the {@link #lastAttacker()} may have an {@link Optional#empty()}
 * value.
 */
public interface DamageableData extends DataManipulator<DamageableData, ImmutableDamageableData> {

    /**
     * Gets the {@link OptionalValue} for the last attacker.
     *
     * @return The last attacker as an optional value
     * @see Keys#LAST_ATTACKER
     */
    OptionalValue<Living> lastAttacker();

    /**
     * Gets the last amount of damage dealt as an optional value.
     *
     * @return The last damage dealt as an optional value
     * @see Keys#LAST_DAMAGE
     */
    OptionalValue<Double> lastDamage();

}
