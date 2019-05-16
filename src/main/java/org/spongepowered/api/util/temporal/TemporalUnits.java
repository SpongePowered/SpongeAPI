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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * An enumeration of all the default and minecraft related {@link TemporalUnit}s.
 */
public final class TemporalUnits {

    /**
     * @see ChronoUnit#NANOS
     */
    public static final ChronoUnit NANOS = ChronoUnit.NANOS;

    /**
     * @see ChronoUnit#MILLIS
     */
    public static final ChronoUnit MILLIS = ChronoUnit.MILLIS;

    /**
     * @see ChronoUnit#SECONDS
     */
    public static final ChronoUnit SECONDS = ChronoUnit.SECONDS;

    /**
     * @see ChronoUnit#MINUTES
     */
    public static final ChronoUnit MINUTES = ChronoUnit.MINUTES;

    /**
     * @see ChronoUnit#HOURS
     */
    public static final ChronoUnit HOURS = ChronoUnit.HOURS;

    /**
     * @see ChronoUnit#HALF_DAYS
     */
    public static final ChronoUnit HALF_DAYS = ChronoUnit.HALF_DAYS;

    /**
     * @see ChronoUnit#DAYS
     */
    public static final ChronoUnit DAYS = ChronoUnit.DAYS;

    /**
     * @see ChronoUnit#WEEKS
     */
    public static final ChronoUnit WEEKS = ChronoUnit.WEEKS;

    /**
     * @see ChronoUnit#MONTHS
     */
    public static final ChronoUnit MONTHS = ChronoUnit.MONTHS;

    /**
     * @see ChronoUnit#YEARS
     */
    public static final ChronoUnit YEARS = ChronoUnit.YEARS;

    /**
     * @see ChronoUnit#DECADES
     */
    public static final ChronoUnit DECADES = ChronoUnit.DECADES;

    /**
     * @see ChronoUnit#CENTURIES
     */
    public static final ChronoUnit CENTURIES = ChronoUnit.CENTURIES;

    /**
     * @see ChronoUnit#MILLENNIA
     */
    public static final ChronoUnit MILLENNIA = ChronoUnit.MILLENNIA;

    /**
     * @see ChronoUnit#ERAS
     */
    public static final ChronoUnit ERAS = ChronoUnit.ERAS;

    /**
     * @see ChronoUnit#FOREVER
     */
    public static final ChronoUnit FOREVER = ChronoUnit.FOREVER;

    /**
     * A {@link TemporalUnit} which represents one minecraft tick.
     */
    public static final TemporalUnit MINECRAFT_TICKS = DummyObjectProvider.createFor(TemporalUnit.class, "MINECRAFT_TICKS");

    /**
     * A {@link TemporalUnit} which represents a minecraft day.
     */
    public static final TemporalUnit MINECRAFT_DAYS = DummyObjectProvider.createFor(TemporalUnit.class, "MINECRAFT_DAYS");

    private TemporalUnits() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
