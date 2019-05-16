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
package org.spongepowered.api;

import org.spongepowered.api.util.temporal.TemporalUnits;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.List;

/**
 * Represents the statistics of a {@link Engine}.
 */
public interface EngineStatistics {

    /**
     * Gets the amount of game loop updates that are being
     * performed per {@link TemporalUnit}.
     *
     * @param unit The temporal unit
     * @return The amount of updates
     */
    double getUpdatesPerUnit(TemporalUnit unit);

    /**
     * Gets the amount of game loop updates that are being
     * performed per second.
     *
     * <p>In vanilla minecraft this value represents the
     * amount of ticks per second.</p>
     *
     * @return The amount of updates
     */
    default double getUpdatesPerSecond() {
        return getUpdatesPerUnit(TemporalUnits.SECONDS);
    }

    /**
     * Gets the average amount of game loop updates that are
     * being performed per {@link TemporalUnit}.
     *
     * @param unit The temporal unit
     * @return The amount of updates
     */
    double getAverageUpdatesPerUnit(TemporalUnit unit);

    /**
     * Gets the average amount of game loop updates that are
     * being performed per second.
     *
     * <p>In vanilla minecraft this value represents the
     * average amount of ticks per second.</p>
     *
     * @return The amount of updates
     */
    default double getAverageUpdatesPerSecond() {
        return getAverageUpdatesPerUnit(TemporalUnits.SECONDS);
    }

    /**
     * Gets a list with {@link Instant}s at which updates
     * have occurred recently.
     *
     * <p>In vanilla minecraft is the size of the list limited
     * to a 100 values.</p>
     *
     * @return The recent update times
     */
    List<Instant> getRecentUpdateTimes();

    /**
     * Gets the duration that the engine has been running for, since the
     * engine started.
     *
     * <p>This value is not persisted across engine restarts, it is set to zero
     * each time the engine starts.</p>
     *
     * @return The duration the engine has been running for
     */
    Duration getRunningTime();
}
