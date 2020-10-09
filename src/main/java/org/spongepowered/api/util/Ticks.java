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

import org.spongepowered.api.Sponge;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Represents a game "tick".
 *
 * <p>A game tick is a unit of work where the game processes the current state
 * and updates the game world and all the entities in it. It is not a true unit
 * of time, however, to ensure a consistent game play experience, each tick is
 * given a maximum processing time (which is generally interpreted to be the
 * expected duration of the tick, rather than the maximum) in which to complete
 * its work. If a tick takes less time than this allotted time, the rest of the
 * allocated time is unused and the engine simply waits for this time to elapse
 * before processing the work for the next tick - this gives rise to the idea of
 * a maximum <em>ticks per second</em>. However, if a tick takes longer than its
 * effective minimum duration, then the next tick must wait for the current tick
 * to finish before it can start. If multiple ticks take longer than this
 * processing time in a row, this will have the effect of reducing the number of
 * "ticks per second" that can run. At this point, the server may be considered
 * "overloaded" as it cannot keep up with the demand placed upon it and not
 * suffer from degradation in performance.</p>
 *
 * <p>Implementations <strong>may</strong> measure the duration of some in-game
 * mechanics using these server ticks. If this is the case, and the server is
 * overloaded, the increased tick time will result in such mechanics taking
 * longer to resolve. To complicate things further, implementations may choose
 * to "skip" ticks to reduce server load (so some mechanics due to run in two
 * tick's time may instead run in one tick's time). Thus, the use of a tick as
 * a time period is unreliable.</p>
 *
 * <p>For these reasons, consumers of this API should not treat a tick as a
 * fixed unit of time. Instead, ticks are an <em>intention of order</em>. A
 * mechanic due to resolve in two ticks will never resolve in a tick before a
 * mechanic that resolves in one tick (but again, due to tick skipping, they
 * may resolve on the same tick).</p>
 *
 * <p>Information about the current platform's expected tick rate can be
 * determined by calling {@link #SINGLE_TICK#getExpectedDuration()}</p>
 */
public interface Ticks {

    /**
     * Represents zero ticks.
     */
    Ticks ZERO_TICKS = Ticks.of(0);

    /**
     * Represents a single tick.
     */
    Ticks SINGLE_TICK = Ticks.of(1);

    /**
     * Represents the number of ticks that represents an in-game day.
     */
    Ticks MINECRAFT_DAY = Ticks.ofMinecraftDays(1);

    /**
     * Returns a {@link Ticks} that represents the supplied number of ticks.
     *
     * <p>This is platform dependent - consult the target implementation for
     * what a tick represents.</p>
     *
     * @param ticks The number of ticks
     * @return A {@link Ticks} object that represents the number of ticks.
     */
    static Ticks of(final long ticks) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).of(ticks);
    }

    /**
     * Returns a {@link Ticks} that would represent the supplied time
     * in the ideal case. If the given time would result in a non-integer number
     * of ticks, the number of ticks will be rounded up, resulting in a slightly
     * larger ideal duration.
     *
     * <p>The supplied time is a lower bound on the wall-clock time - if the
     * server is overloaded the time taken to execute the number of ticks
     * this represents will be higher.</p>
     *
     * @param time The time
     * @param temporalUnit The {@link TemporalUnit} of time given in {@code time}.
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks of(final int time, final TemporalUnit temporalUnit) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).of(time, temporalUnit);
    }

    /**
     * Returns a {@link Ticks} that would be executed in the given number of
     * seconds in an ideal case.
     *
     * @param seconds The number of seconds
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks ofSeconds(final int seconds) {
        return Ticks.of(seconds, ChronoUnit.SECONDS);
    }

    /**
     * Returns a {@link Ticks} that would be executed in the given number of
     * minutes in an ideal case.
     *
     * @param minutes The number of seconds
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks ofMinutes(final int minutes) {
        return Ticks.of(minutes, ChronoUnit.MINUTES);
    }

    /**
     * Returns a {@link Ticks} that would be executed in the given number of
     * hours in an ideal case.
     *
     * @param hours The number of hours
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks ofHours(final int hours) {
        return Ticks.of(hours, ChronoUnit.HOURS);
    }

    /**
     * Returns a {@link Ticks} that would be executed in the given number of
     * days in an ideal case.
     *
     * @param days The number of days
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks ofDays(final int days) {
        return Ticks.of(days, ChronoUnit.DAYS);
    }

    /**
     * Returns a {@link Ticks} that would correspond to the supplied number of
     * in game days, rounded to the nearest tick.
     */
    static Ticks ofMinecraftDays(final double days) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).ofMinecraftDays(days);
    }

    /**
     * Returns a {@link Ticks} that would correspond to the supplied number of
     * in game hours, rounded to the nearest tick.
     */
    static Ticks ofMinecraftHours(final double hours) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).ofMinecraftDays(hours / 24.0);
    }

    /**
     * Gets the expected {@link Duration} of this {@link Ticks} if the server
     * is not overloaded.
     *
     * @return The effective {@link Duration}.
     */
    Duration getExpectedDuration();

    /**
     * Gets the underlying number of ticks that this object represents.
     *
     * <p><strong>This number is platform dependant.</strong> It should not be
     * stored and used beyond the current server session.</p>
     *
     * @return The number of ticks that this represents.
     */
    long getTicks();

    /**
     * Produces {@link Ticks} objects.
     */
    interface Factory {

        /**
         * @see Ticks#of(long)
         */
        Ticks of(long ticks);

        /**
         * @see Ticks#of(int, TemporalUnit)
         */
        Ticks of(int time, TemporalUnit temporalUnit);

        /**
         * @see Ticks#ofMinecraftDays(double)
         */
        Ticks ofMinecraftDays(double minecraftDays);

    }

}
