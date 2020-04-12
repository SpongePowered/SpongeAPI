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

import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

/**
 * Represents a duration.
 */
public interface Duration {

    /**
     * Gets a duration that's zero.
     *
     * @return The zero duration
     */
    static Duration zero() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).zero();
    }

    /**
     * Gets a duration that's infinite.
     *
     * @return The infinite duration
     */
    static Duration infinite() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).infinite();
    }

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
     * Creates a time based duration for the given {@code nanos}.
     *
     * @param nanos The nanos
     * @return The time based duration
     */
    static Duration.Time ofNanos(double nanos) {
        return of(nanos, ChronoUnit.NANOS);
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
     * Creates a duration for the given {@link TemporalAmount}.
     *
     * @return The duration
     */
    static Duration.Time of(TemporalAmount amount) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).of(amount);
    }

    /**
     * Gets the {@link Duration} between the two {@link Temporal} objects.
     *
     * @param startInclusive The start time, inclusive
     * @param endExclusive The end time, exclusive
     * @return The duration
     */
    static Duration.Time between(Temporal startInclusive, Temporal endExclusive) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class)
                .between(startInclusive, endExclusive);
    }

    /**
     * Parses a {@link Duration} from a string such as
     * {@code PnDTnHnMn.nS} for time or {@code nT} for ticks.
     *
     * <p>The parsing behavior is mostly the same as {@link java.time.Duration#parse(CharSequence)},
     * but with the addition to support tick based durations. The following list are examples for
     * tick based durations.
     * </p>
     *
     * <p>
     * Tick based examples:
     * <pre>
     *    "P100T"    -- parses as "100 ticks"
     *    "P+100T"   -- parses as "100 ticks"
     *    "P-100T"   -- parses as "-100 ticks"
     *    "-P100T"   -- parses as "-100 ticks"
     *    "-P-100T"  -- parses as "100 ticks"
     * </pre>
     * </p>
     *
     * @param text The text to parse
     * @return The parsed duration
     * @throws DateTimeParseException If the text cannot be parsed to a duration
     * @see java.time.Duration#parse(CharSequence)
     */
    static Duration parse(CharSequence text) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).parse(text);
    }

    /**
     * Gets whether the duration is zero.
     *
     * @return Is zero
     */
    boolean isZero();

    /**
     * Gets whether the duration is negative.
     *
     * @return Is negative
     */
    boolean isNegative();

    /**
     * Gets whether the duration is infinite.
     *
     * @return Is infinite
     */
    boolean isInfinite();

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
     * Gets a new duration which is negated.
     *
     * @return The new negated duration
     */
    Duration negated();

    /**
     * Gets a new duration which is absolute.
     *
     * @return The new absolute duration
     */
    Duration abs();

    /**
     * Multiplies this duration by the given value.
     *
     * @param value The value to multiply the duration by
     * @return The new duration
     */
    Duration multipliedBy(long value);

    /**
     * Divides this duration by the given value.
     *
     * @param value The value to divide the duration by
     * @return The new duration
     */
    Duration dividedBy(long value);

    /**
     * This converts the duration to a string representation. Which
     * can be parsed by {@link #parse(CharSequence)}.
     *
     * @return The string representation
     */
    @Override
    String toString();

    /**
     * Represents a duration that is directly related to time and a clock.
     */
    interface Time extends Duration, Comparable<Time> {

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
         * Converts this duration to milliseconds.
         *
         * @return The milliseconds
         */
        default long toLongMillis() {
            return this.toLong(ChronoUnit.MILLIS);
        }

        /**
         * Converts this duration to nanoseconds.
         *
         * @return The nanoseconds
         */
        default double toNanos() {
            return this.to(ChronoUnit.NANOS);
        }

        /**
         * Converts this duration to nanoseconds.
         *
         * @return The nanoseconds
         */
        default long toLongNanos() {
            return this.toLong(ChronoUnit.NANOS);
        }

        /**
         * Converts this duration to the given {@link TemporalUnit}.
         *
         * @return The duration
         */
        double to(TemporalUnit unit);

        /**
         * Converts this duration to the given {@link TemporalUnit} as a long value.
         *
         * @return The duration
         */
        long toLong(TemporalUnit unit);

        /**
         * Adds the days and returns the new duration.
         *
         * @param days The days to add
         * @return The new duration
         */
        default Time plusDays(double days) {
            return this.plus(days, ChronoUnit.DAYS);
        }

        /**
         * Adds the hours and returns the new duration.
         *
         * @param hours The hours to add
         * @return The new duration
         */
        default Time plusHours(double hours) {
            return this.plus(hours, ChronoUnit.HOURS);
        }

        /**
         * Adds the minutes and returns the new duration.
         *
         * @param minutes The minutes to add
         * @return The new duration
         */
        default Time plusMinutes(double minutes) {
            return this.plus(minutes, ChronoUnit.MINUTES);
        }

        /**
         * Adds the seconds and returns the new duration.
         *
         * @param seconds The seconds to add
         * @return The new duration
         */
        default Time plusSeconds(double seconds) {
            return this.plus(seconds, ChronoUnit.SECONDS);
        }

        /**
         * Adds the millis and returns the new duration.
         *
         * @param millis The millis to add
         * @return The new duration
         */
        default Time plusMillis(double millis) {
            return this.plus(millis, ChronoUnit.MILLIS);
        }

        /**
         * Adds the nanos and returns the new duration.
         *
         * @param nanos The nanos to add
         * @return The new duration
         */
        default Time plusNanos(double nanos) {
            return this.plus(nanos, ChronoUnit.NANOS);
        }

        /**
         * Adds the other duration and returns the new duration.
         *
         * @param value The duration to add
         * @param unit The unit of the duration
         * @return The new duration
         */
        Time plus(double value, TemporalUnit unit);

        /**
         * Adds the other duration and returns the new duration.
         *
         * @param other The other duration to add
         * @return The new duration
         */
        Time plus(Time other);

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param days The days to subtract
         * @return The new duration
         */
        default Time minusDays(double days) {
            return this.minus(days, ChronoUnit.DAYS);
        }

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param hours The hours to subtract
         * @return The new duration
         */
        default Time minusHours(double hours) {
            return this.minus(hours, ChronoUnit.HOURS);
        }

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param minutes The minutes to subtract
         * @return The new duration
         */
        default Time minusMinutes(double minutes) {
            return this.minus(minutes, ChronoUnit.MINUTES);
        }

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param seconds The seconds to subtract
         * @return The new duration
         */
        default Time minusSeconds(double seconds) {
            return this.minus(seconds, ChronoUnit.SECONDS);
        }

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param millis The millis to subtract
         * @return The new duration
         */
        default Time minusMillis(double millis) {
            return this.minus(millis, ChronoUnit.MILLIS);
        }

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param nanos The nanos to subtract
         * @return The new duration
         */
        default Time minusNanos(double nanos) {
            return this.minus(nanos, ChronoUnit.NANOS);
        }

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param value The duration to subtract
         * @param unit The unit of the duration
         * @return The new duration
         */
        Time minus(double value, TemporalUnit unit);

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param other The other duration to subtract
         * @return The new duration
         */
        Time minus(Time other);

        @Override
        Time abs();

        @Override
        Time negated();

        /**
         * Multiplies this duration by the given value.
         *
         * @param value The value to multiply the duration by
         * @return The new duration
         */
        Time multipliedBy(double value);

        @Override
        Time multipliedBy(long value);

        /**
         * Divides this duration by the given value.
         *
         * @param value The value to divide the duration by
         * @return The new duration
         */
        Time dividedBy(double value);

        @Override
        Time dividedBy(long value);

        @Override
        default Time toTime() {
            return this;
        }

        /**
         * Converts this duration to the java
         * {@link java.time.Duration}.
         *
         * @return The java duration
         */
        java.time.Duration toJavaDuration();
    }

    /**
     * Represents a duration that is tick based. Ticks are also related
     * to time, but this is less strict because it's affected by the
     * performance of the engine.
     */
    interface Ticks extends Duration, Comparable<Ticks> {

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
        long get();

        /**
         * Adds the ticks and returns the new duration.
         *
         * @param ticks The ticks to add
         * @return The duration
         */
        Ticks plus(long ticks);

        /**
         * Adds the other duration and returns the new duration.
         *
         * @param other The other duration to add
         * @return The new duration
         */
        Ticks plus(Ticks other);

        /**
         * Subtracts the other ticks from this one and returns the new duration.
         *
         * @param ticks The ticks to subtract
         * @return The duration
         */
        Ticks minus(long ticks);

        /**
         * Subtracts the other duration from this one and returns the new duration.
         *
         * @param other The other duration to subtract
         * @return The new duration
         */
        Ticks minus(Ticks other);

        @Override
        Ticks abs();

        @Override
        Ticks negated();

        @Override
        Ticks multipliedBy(long value);

        @Override
        Ticks dividedBy(long value);

        @Override
        default Ticks toTicks() {
            return this;
        }
    }

    interface Factory {

        Duration parse(CharSequence text);

        Duration zero();

        Duration infinite();

        Duration.Time of(TemporalAmount amount);

        Duration.Time of(double value, TemporalUnit unit);

        Duration.Time between(Temporal startInclusive, Temporal endExclusive);

        Duration.Ticks ofTicks(long ticks);
    }
}
