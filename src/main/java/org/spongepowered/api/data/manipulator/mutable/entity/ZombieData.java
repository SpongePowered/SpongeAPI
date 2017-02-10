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
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableZombieData;
import org.spongepowered.api.data.type.Profession;
import org.spongepowered.api.data.type.ZombieType;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.living.monster.Zombie;

import java.util.Optional;

/**
 * Represents an {@link DataManipulator} handling the type and
 * profession of a {@link Zombie}.
 */
public interface ZombieData extends DataManipulator<ZombieData, ImmutableZombieData> {

    /**
     * Returns a value specifying Zombie's type.

     * @return Zombie's type
     * @see Keys#ZOMBIE_TYPE
     */
    Value<ZombieType> type();

    /**
     * Value representing a zombie's zombie's {@link Profession}.
     *
     * @return Profession of the zombie, or {@link Optional#empty()} if it has none
     * @see Keys#VILLAGER_ZOMBIE_PROFESSION
     */
    OptionalValue<Profession> profession();

}
