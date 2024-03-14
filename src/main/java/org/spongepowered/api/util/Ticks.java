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

import org.spongepowered.api.Engine;
import org.spongepowered.api.Server;
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
 * <p>Information about the current platform and {@link Engine Engine's}
 * expected tick rate can be determined by calling
 * {@link #single()}.{@link #expectedDuration(Engine)}. The tick rate is not defined by the
 * API so may vary amongst different implementations. For all engines based on
 * vanilla Minecraft, this is 50ms for a 20 tick per second rate.</p>
 *
 * <p>While a tick is not a reliable measure of wall-clock time, implementations
 * may tie in-game world time to a given number of ticks. This object can thus
 * be used as an accurate <strong>in-game</strong> duration. However, it is not
 * defined in the API what the correlation between ticks and in-game time is,
 * again, this may vary amongst implementations. For vanilla Minecraft, 1000
 * ticks corresponds to one in-game hour, meaning there is <strong>not</strong>
 * an integer correspondence between an in-game minute or second and number of
 * ticks.</p>
 *
 * <p>Note that this object does not hold any context about which {@link Engine}
 * the number of ticks was generated for. Consumers should use the methods on
 * this object to determine what this object would represent on the target
 * engine.</p>
 */
public interface Ticks {

    /**
     * Represents zero ticks.
     *
     * @return A {@link Ticks}
     */
    static Ticks zero() {
        return Sponge.game().factoryProvider().provide(Ticks.Factory.class).zero();
    }

    /**
     * Represents a single tick.
     *
     * @return A {@link Ticks}
     */
    static Ticks single() {
        return Sponge.game().factoryProvider().provide(Ticks.Factory.class).single();
    }

    /**
     * Represents a minecraft hour on the {@link Server} in ticks.
     *
     * @return A {@link Ticks}
     */
    static Ticks minecraftHour() {
        return Sponge.game().factoryProvider().provide(Ticks.Factory.class).minecraftHour();
    }

    /**
     * Represents a minecraft day on the {@link Server} in ticks.
     *
     * @return A {@link Ticks}
     */
    static Ticks minecraftDay() {
        return Sponge.game().factoryProvider().provide(Ticks.Factory.class).minecraftDay();
    }

    /**
     * Represents infinite ticks.
     *
     * @return A {@link Ticks}
     */
    static Ticks infinite() {
        return Sponge.game().factoryProvider().provide(Ticks.Factory.class).infinite();
    }

    /**
     * Returns a {@link Ticks} that represents the supplied number of ticks.
     *
     * <p>This is platform and potentially {@link Engine} dependent - consult
     * the target implementation for what a tick represents.</p>
     *
     * @param ticks The number of ticks
     * @return A {@link Ticks} object that represents the number of ticks.
     */
    static Ticks of(final long ticks) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(ticks);
    }

    /**
     * Returns a {@link Ticks} that would represent the supplied wall-clock time
     * in the ideal case for the given {@link Engine}. If the given time would
     * result in a non-integer number of ticks, the number of ticks will be
     * rounded up, resulting in a slightly larger ideal duration.
     *
     * <p>The supplied time is a lower bound on the wall-clock time - if the
     * engine is overloaded the time taken to execute the number of ticks
     * this represents will be higher.</p>
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param time The time
     * @param temporalUnit The {@link TemporalUnit} of time given in {@code time}.
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run on the given engine in an ideal scenario.
     */
    static Ticks ofWallClockTime(final Engine engine, final long time, final TemporalUnit temporalUnit) {
        return Sponge.game().factoryProvider().provide(Factory.class).ofWallClockTime(engine, time, temporalUnit);
    }

    /**
     * Returns a {@link Ticks} that would be executed in the given number of
     * wall-clock seconds on the given {@link Engine} in an ideal case.
     *
     * @see #ofWallClockTime(Engine, long, TemporalUnit)
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param seconds The number of seconds
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run on the given engine in an ideal scenario.
     */
    static Ticks ofWallClockSeconds(final Engine engine, final int seconds) {
        return Ticks.ofWallClockTime(engine, seconds, ChronoUnit.SECONDS);
    }

    /**
     * Returns a {@link Ticks} that would be executed in the given number of
     * wall-clock minutes on the given {@link Engine} in an ideal case.
     *
     * @see #ofWallClockTime(Engine, long, TemporalUnit)
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param minutes The number of minutes
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run on the given engine in an ideal scenario.
     */
    static Ticks ofWallClockMinutes(final Engine engine, final int minutes) {
        return Ticks.ofWallClockTime(engine, minutes, ChronoUnit.MINUTES);
    }

    /**
     * Returns a {@link Ticks} that would be executed in the given number of
     * wall-clock hours on the given {@link Engine} in an ideal case.
     *
     * @see #ofWallClockTime(Engine, long, TemporalUnit)
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param hours The number of hours
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run on the given engine in an ideal scenario.
     */
    static Ticks ofWallClockHours(final Engine engine, final int hours) {
        return Ticks.ofWallClockTime(engine, hours, ChronoUnit.HOURS);
    }

    /**
     * Returns a {@link Ticks} that would be executed in the given number of
     * wall-clock days on the given {@link Engine} in an ideal case.
     *
     * @see #ofWallClockTime(Engine, long, TemporalUnit)
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param days The number of days
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run on the given engine in an ideal scenario.
     */
    static Ticks ofWallClockDays(final Engine engine, final int days) {
        return Ticks.ofWallClockTime(engine, days, ChronoUnit.DAYS);
    }

    /**
     * Returns a {@link Ticks} that represents the given number of Minecraft
     * day-time seconds on the given {@link Engine}.
     *
     * <p>As a tick may not be an integer number of minecraft seconds, the
     * returned {@link Ticks} object may be slightly larger than requested. The
     * number of ticks returned will always be at least the requested duration.
     * </p>
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param seconds The number of minecraft seconds
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks ofMinecraftSeconds(final Engine engine, final long seconds) {
        return Sponge.game().factoryProvider().provide(Factory.class).ofMinecraftSeconds(engine, seconds);
    }

    /**
     * Returns a {@link Ticks} that represents the given number of Minecraft
     * day-time seconds on the given {@link Engine}.
     *
     * <p>As a tick may not be an integer number of minecraft minutes, the
     * returned {@link Ticks} object may be slightly larger than requested. The
     * number of ticks returned will always be at least the requested duration.
     * </p>
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param minutes The number of minecraft minutes
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks ofMinecraftMinutes(final Engine engine, final long minutes) {
        return Sponge.game().factoryProvider().provide(Factory.class).ofMinecraftSeconds(engine, minutes * 60);
    }

    /**
     * Returns a {@link Ticks} that represents the given number of Minecraft
     * day-time hours on the given {@link Engine}.
     *
     * <p>As a tick may not be an integer number of minecraft hours, the
     * returned {@link Ticks} object may be slightly larger than requested. The
     * number of ticks returned will always be at least the requested duration.
     * </p>
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param hours The number of minecraft hours
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks ofMinecraftHours(final Engine engine, final long hours) {
        return Ticks.ofMinecraftMinutes(engine, hours * 60);
    }

    /**
     * Returns a {@link Ticks} that represents the given number of Minecraft
     * day-time days on the given {@link Engine}.
     *
     * <p>As a tick may not be an integer number of minecraft days, the
     * returned {@link Ticks} object may be slightly larger than requested. The
     * number of ticks returned will always be at least the requested duration.
     * </p>
     *
     * @param engine The {@link Engine} to calculate the number of ticks for
     * @param days The number of minecraft days
     * @return The {@link Ticks} that represents the number of ticks that would
     *      be expected to be run in an ideal scenario.
     */
    static Ticks ofMinecraftDays(final Engine engine, final long days) {
        return Ticks.ofMinecraftHours(engine, days * 24);
    }

    /**
     * Gets the expected {@link Duration} of time it would take for the given
     * {@link Engine} to process the number of ticks this object represents
     * under ideal conditions.
     *
     * @param engine The {@link Engine} to get the {@link Duration} for
     * @return The effective {@link Duration}.
     * @throws IllegalStateException If {@see isInfinite} is true.
     */
    Duration expectedDuration(final Engine engine);

    /**
     * Gets the underlying number of ticks that this object represents.
     *
     * <p><strong>This number is platform and {@link Engine} dependent.</strong>
     * It should not be stored and used beyond the current {@link Engine}
     * session.</p>
     *
     * @return The number of ticks that this represents.
     * @throws IllegalStateException If {@see isInfinite} is true.
     */
    long ticks();

    /**
     * Gets the number of in-game seconds that this {@link Ticks} represents for
     * the given {@link Engine}.
     *
     * <p>As there may not be a integer - integer relationship between seconds
     * and ticks, this may be approximate. If the conversion results in
     * a millisecond remainder, the duration is truncated rather than rounded -
     * that is, if this object represents 6.7 seconds, this will return 6, not
     * 7.</p>
     *
     * @param engine The {@link Engine} to calculate the duration for.
     * @return The approximate number of in-game seconds
     * @throws IllegalStateException If {@see isInfinite} is true.
     */
    long minecraftSeconds(final Engine engine);

    /**
     * Returns the <strong>in-game time</strong> as a {@link Duration}
     * represents for the given {@link Engine}.
     *
     * <p><strong>This is not wall-clock time.</strong> This should not be used
     * with any {@link Duration} that represents wall-clock times.</p>
     *
     * @param engine The {@link Engine} to calculate the duration for.
     * @return A duration representing the in game time.
     * @throws IllegalStateException If {@see isInfinite} is true.
     */
    Duration minecraftDayTimeDuration(final Engine engine);

    /**
     * Whether this represents infinite ticks.
     *
     * <p>When this is true all other methods throw {@link IllegalStateException}.</p>
     *
     * @return True if this represents infinite ticks.
     */
    boolean isInfinite();

    /**
     * Produces {@link Ticks} objects.
     */
    interface Factory {

        /**
         * @see Ticks#of(long)
         *
         * @param ticks The number of ticks
         * @return A {@link Ticks} object that represents the number of ticks.
         */
        Ticks of(long ticks);

        /**
         * @see Ticks#ofWallClockTime(Engine, long, TemporalUnit) (long, TemporalUnit)
         *
         * @param engine The {@link Engine} to calculate the number of ticks for
         * @param time The time
         * @param temporalUnit The {@link TemporalUnit} of time given in {@code time}.
         * @return The {@link Ticks} that represents the number of ticks that would
         *      be expected to be run on the given engine in an ideal scenario.
         */
        Ticks ofWallClockTime(Engine engine, long time, TemporalUnit temporalUnit);

        /**
         * @see Ticks#ofMinecraftSeconds(Engine, long)
         *
         * @param engine The {@link Engine} to calculate the number of ticks for
         * @param time The number of minecraft seconds
         * @return The {@link Ticks} that represents the number of ticks that would
         *      be expected to be run in an ideal scenario.
         */
        Ticks ofMinecraftSeconds(Engine engine, long time);

        /**
         * @see Ticks#ofMinecraftHours(Engine, long)
         *
         * @param engine The {@link Engine} to calculate the number of ticks for
         * @param time The number of minecraft hours
         * @return The {@link Ticks} that represents the number of ticks that would
         *      be expected to be run in an ideal scenario.
         */
        Ticks ofMinecraftHours(Engine engine, long time);

        /**
         * @see Ticks#zero()
         *
         * @return A {@link Ticks}
         */
        Ticks zero();

        /**
         * @see Ticks#single()
         *
         * @return A {@link Ticks}
         */
        Ticks single();

        /**
         * @see Ticks#minecraftHour()
         *
         * @return A {@link Ticks}
         */
        Ticks minecraftHour();

        /**
         * @see Ticks#minecraftDay()
         *
         * @return A {@link Ticks}
         */
        Ticks minecraftDay();

        /**
         * @see Ticks#infinite()
         *
         * @return A {@link Ticks}
         */
        Ticks infinite();

    }

}
