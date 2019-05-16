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
package org.spongepowered.api.util.temporal;

import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

/**
 * Represents a value that is affected by a
 * {@link TemporalAmount}.
 *
 * @param <V> The number type
 */
public interface TemporalBasedValue<V> {

    /**
     * Gets the value based on the given {@link TemporalUnit}.
     *
     * @param temporalUnit The temporal unit
     * @return The value based on the temporal unit
     */
    default V get(TemporalUnit temporalUnit) {
        return get(temporalUnit.getDuration());
    }

    /**
     * Gets the value based on the given {@link TemporalAmount}.
     *
     * @param temporalAmount The temporal amount
     * @return The value based on the temporal amount
     */
    V get(TemporalAmount temporalAmount);

}
