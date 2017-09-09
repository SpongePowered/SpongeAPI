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
package org.spongepowered.api.entity.explosive;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.entity.FuseData;

/**
 * Represents an explosive that detonates after its fuse has expired.
 * <p>A FusedExplosive may already be ignited once spawned.</p>
 */
public interface FusedExplosive extends Explosive {

    /**
     * Returns the {@link FuseData} for this explosive.
     *
     * @return FuseData
     */
    default FuseData getFuseData() {
        return get(FuseData.class).get();
    }

    /**
     * Returns true if this explosive is currently primed.
     *
     * @return True if primed
     */
    boolean isPrimed();

    /**
     * Primes this explosive to detonate after the amount of ticks that
     * this entity explodes in defined by {@link Keys#FUSE_DURATION}.
     *
     * @throws IllegalStateException if explosive already primed
     */
    void prime();

    /**
     * Cancels an actively primed explosive.
     *
     * @throws IllegalStateException if explosive is not primed
     */
    void defuse();

}
