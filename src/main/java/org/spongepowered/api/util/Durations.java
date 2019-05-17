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
package org.spongepowered.api.util;

import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.api.util.temporal.TemporalUnits;

import java.time.Duration;

/**
 * Utilities to create {@link Duration}s.
 */
@NonnullByDefault
public final class Durations {

    /**
     * Creates a {@link Duration} from the given milliseconds.
     *
     * @param millis The milliseconds
     * @return The duration
     */
    public static Duration ofMillis(long millis) {
        return Duration.ofMillis(millis);
    }

    /**
     * Creates a {@link Duration} from the given seconds.
     *
     * @param seconds The seconds
     * @return The duration
     */
    public static Duration ofSeconds(long seconds) {
        return Duration.ofSeconds(seconds);
    }

    /**
     * Creates a {@link Duration} from the given minecraft ticks.
     *
     * @param minecraftTicks The minecraft ticks
     * @return The duration
     */
    public static Duration ofMinecraftTicks(long minecraftTicks) {
        return Duration.of(minecraftTicks, TemporalUnits.MINECRAFT_TICKS);
    }

    /**
     * Creates a {@link Duration} from the given minecraft days.
     *
     * @param minecraftDays The minecraft days
     * @return The duration
     */
    public static Duration ofMinecraftDays(long minecraftDays) {
        return Duration.of(minecraftDays, TemporalUnits.MINECRAFT_DAYS);
    }

    private Durations() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
