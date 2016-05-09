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
import org.spongepowered.api.data.manipulator.mutable.entity.FuseData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.explosive.FusedExplosive;

/**
 * Represents information about a {@link FusedExplosive}'s fuse.
 */
public interface ImmutableFuseData extends ImmutableDataManipulator<ImmutableFuseData, FuseData> {

    /**
     * The amount of ticks before the {@link FusedExplosive} detonates when
     * primed.
     *
     * @return Amount of ticks before detonation when primed
     */
    ImmutableValue<Integer> fuseDuration();

    /**
     * The amount of ticks before {@link FusedExplosive} detonates. This value
     * may be zero if the {@link FusedExplosive} is not currently primed nor
     * will setting this value have any effect if the {@link FusedExplosive} is
     * not primed.
     *
     * @return Amount of ticks before impending detonation
     */
    ImmutableValue<Integer> ticksRemaining();

}
