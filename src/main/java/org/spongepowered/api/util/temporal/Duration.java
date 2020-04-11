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

import org.spongepowered.api.Engine;
import org.spongepowered.api.Sponge;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

/**
 * Represents a duration.
 */
public interface Duration extends TemporalAmount {

    /**
     * Creates a tick based duration based on the given {@code ticks}.
     *
     * @param ticks The amount of ticks
     * @return The tick based duration
     */
    static Duration.Ticks ofTicks(long ticks) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).ofTicks(ticks);
    }

    /**
     * Creates a time based duration for the given {@code days}.
     *
     * @param days The days
     * @return The time based duration
     */
    static Duration.Time ofDays(double days) {
        return of(days, ChronoUnit.DAYS);
    }

    /**
     * Creates a time based duration for the given {@code hours}.
     *
     * @param hours The hours
     * @return The time based duration
     */
    static Duration.Time ofHours(double hours) {
        return of(hours, ChronoUnit.HOURS);
    }

    /**
     * Creates a time based duration for the given {@code minutes}.
     *
     * @param minutes The minutes
     * @return The time based duration
     */
    static Duration.Time ofMinutes(double minutes) {
        return of(minutes, ChronoUnit.MINUTES);
    }

    /**
     * Creates a time based duration for the given {@code seconds}.
     *
     * @param seconds The seconds
     * @return The time based duration
     */
    static Duration.Time ofSeconds(double seconds) {
        return of(seconds, ChronoUnit.SECONDS);
    }

    /**
     * Creates a time based duration for the given {@code millis}.
     *
     * @param millis The millis
     * @return The time based duration
     */
    static Duration.Time ofMillis(double millis) {
        return of(millis, ChronoUnit.MILLIS);
    }

    /**
     * Creates a time based duration for the given {@code value} and {@code unit}.
     *
     * @param value The amount of time
     * @param unit The unit of the time
     * @return The time based duration
     */
    static Duration.Time of(double value, TemporalUnit unit) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).of(value, unit);
    }

    /**
     * Converts this duration to tick based duration.
     *
     * <p>This is the optimal conversion to ticks, unrelated to
     * the performance of the engine. This will consistently
     * return the same value.</p>
     *
     * <p>If you want to get the amount of ticks, based on the
     * engine performance, you can use
     * {@link Engine#getEstimatedTicks(Duration)}.</p>
     *
     * @return The ticks
     */
    Ticks toTicks();

    /**
     * Converts this duration to a time (clock) based duration.
     *
     * <p>This is the optimal conversion from ticks, unrelated to
     * the performance of the engine. This will consistently
     * return the same value.</p>
     *
     * <p>If you want to get the amount of time, based on the
     * engine performance, you can use
     * {@link Engine#getEstimatedTime(Duration)}.</p>
     *
     * @return The time
     */
    Time toTime();

    /**
     * Represents a duration that is directly related to time and a clock.
     */
    interface Time extends Duration {

        /**
         * Converts this duration to days.
         *
         * @return The days
         */
        default double toDays() {
            return this.to(ChronoUnit.DAYS);
        }

        /**
         * Converts this duration to hours.
         *
         * @return The hours
         */
        default double toHours() {
            return this.to(ChronoUnit.HOURS);
        }

        /**
         * Converts this duration to minutes.
         *
         * @return The minutes
         */
        default double toMinutes() {
            return this.to(ChronoUnit.MINUTES);
        }

        /**
         * Converts this duration to seconds.
         *
         * @return The seconds
         */
        default double toSeconds() {
            return this.to(ChronoUnit.SECONDS);
        }

        /**
         * Converts this duration to milliseconds.
         *
         * @return The milliseconds
         */
        default double toMillis() {
            return this.to(ChronoUnit.MILLIS);
        }

        /**
         * Converts this duration to the given {@link TemporalUnit}.
         *
         * @return The duration
         */
        double to(TemporalUnit unit);

        /**
         * Adds the two durations and returns the new duration.
         *
         * @param other The other duration to add
         * @return The duration
         */
        Time plus(Time other);

        /**
         * Subtracts the two durations and returns the new duration.
         *
         * @param other The other duration to add
         * @return The duration
         */
        Time minus(Time other);

        @Override
        default Time toTime() {
            return this;
        }
    }

    /**
     * Represents a duration that is tick based. Ticks are also related
     * to time, but this is less strict because it's affected by the
     * performance of the engine.
     */
    interface Ticks extends Duration {

        /**
         * Converts this duration to ticks.
         *
         * <p>This is the optimal conversion to ticks, unrelated to
         * the performance of the engine. This will consistently
         * return the same value.</p>
         *
         * <p>If you want to get the amount of ticks, based on the
         * engine performance, you can use
         * {@link Engine#getEstimatedTime(Duration)}.</p>
         *
         * @return The ticks
         */
        long getTicks();

        /**
         * Adds the two durations and returns the new duration.
         *
         * @param other The other duration to add
         * @return The duration
         */
        Ticks plus(Ticks other);

        /**
         * Subtracts the two durations and returns the new duration.
         *
         * @param other The other duration to subtract
         * @return The duration
         */
        Ticks minus(Ticks other);

        @Override
        default Ticks toTicks() {
            return this;
        }
    }

    interface Factory {

        Duration.Time of(double value, TemporalUnit unit);

        Duration.Ticks ofTicks(long ticks);
    }
}
