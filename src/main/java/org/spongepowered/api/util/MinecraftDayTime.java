package org.spongepowered.api.util;

import org.spongepowered.api.Sponge;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Represents an in-game time of day.
 */
public interface MinecraftDayTime {

    /**
     * A {@link MinecraftDayTime} that represents the Minecraft Epoch, which is
     * 6:00am on Day 1.
     */
    MinecraftDayTime MINECRAFT_EPOCH = MinecraftDayTime.of(Ticks.ZERO_TICKS);

    /**
     * Creates a {@link MinecraftDayTime} based on the in-game time since the
     * Minecraft epoch (6:00am on Day 1).
     *
     * <p>For example, if the supplied {@link Duration} was 1 day, 3 hours and
     * 40 minutes, this would correspond to an in game time of 9:40am on Day 2.
     * </p>
     *
     * <p>In the case where the supplied {@link Duration} does not completely
     * align with a valid {@link MinecraftDayTime}, the nearest valid time will
     * be returned.</p>
     *
     * @param duration The duration since the Minecraft Epoch.
     * @return The {@link MinecraftDayTime}
     * @throws IllegalArgumentException if the duration is negative
     */
    static MinecraftDayTime ofInGameDuration(final Duration duration) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(MinecraftDayTime.Factory.class).of(duration);
    }

    /**
     * Creates a {@link MinecraftDayTime} that represents the world time
     * if the world has been running for the supplied {@link Duration} in
     * real world time under idealised conditions.
     *
     * <p>For example, if the supplied {@link Duration} was 1 day, 3 hours and
     * 40 minutes and each Minecraft day lasts 20 minutes in the vanilla game,
     * this would correspond to 6:00am on day 84 (1 day, 3 hours and 40 minutes
     * is 1660 minutes, which is 83 20-minute chunks).</p>
     *
     * <p>In the case where the supplied {@link Duration} does not completely
     * align with a valid {@link MinecraftDayTime}, the nearest valid time will
     * be returned.</p>
     *
     * @param duration The wall-clock duration
     * @return The {@link MinecraftDayTime}
     * @throws IllegalArgumentException if the duration is negative
     */
    static MinecraftDayTime ofWallClockDuration(final Duration duration) {
        return MinecraftDayTime.of(Ticks.of(duration.toMillis(), ChronoUnit.MILLIS));
    }

    /**
     * Creates a {@link MinecraftDayTime} that corresponds to the given
     * units of in-game time.
     *
     * <p>The parameters are subject to the following constraints:</p>
     *
     * <ul>
     *     <li>{@code day} must be positive;</li>
     *     <li>{@code hour} is in 24-hour time, and so must be between 0 and 23,
     *     <strong>except</strong> on day 1, where it must be between 6 and 23;
     *     and</li>
     *     <li>{@code minute} must be between 0 and 59.</li>
     * </ul>
     *
     * <p>In the case where the supplied time does not completely align with a
     * valid {@link MinecraftDayTime}, the nearest valid time will be returned.
     * </p>
     *
     * @param day The day to set. Must be positive.
     * @param hours The hour to set in 24 hour time.
     * @param minutes The minute to set.
     * @return The {@link MinecraftDayTime}.
     * @throws IllegalArgumentException if any of the listed constraints are
     *      violated.
     */
    static MinecraftDayTime of(final int day, final int hours, final int minutes) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(MinecraftDayTime.Factory.class).of(day, hours, minutes);
    }

    /**
     * Creates a {@link MinecraftDayTime} based on the number of {@link Ticks}
     * elapsed since the Minecraft epoch (6:00am on Day 1).
     *
     * <p>For example, if the supplied {@link Ticks} was {@code Ticks.of(18000)
     * on the vanilla server, this would correspond to an in game time of
     * 12:00am on Day 2 (18 hours after Minecraft epoch).</p>
     *
     * @param ticks The {@link Ticks} since the Minecraft Epoch.
     * @return The {@link MinecraftDayTime}
     * @throws IllegalArgumentException if the tick count is negative
     */
    static MinecraftDayTime of(final Ticks ticks) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(MinecraftDayTime.Factory.class).of(ticks);
    }

    /**
     * The day this represents.
     *
     * @return The day
     */
    int day();

    /**
     * The hour this represents.
     *
     * @return The hour.
     */
    int hour();

    /**
     * The minute this represents.
     *
     * @return The minute.
     */
    int minute();

    /**
     * Adds the time given by the arguments and returns a new object with
     * the result.
     *
     * @param days The number of days to advance
     * @param hour The number of hours to advance (between 0 and 23)
     * @param minute The number of minutes to advance (between 0 and 59)
     * @return A new {@link MinecraftDayTime}
     * @throws IllegalArgumentException if any of the arguments are negative.
     */
    MinecraftDayTime plus(int days, int hour, int minute);

    /**
     * Subtracts the time given by the arguments and returns a new object with
     * the result.
     *
     * @param days The number of days to advance
     * @param hour The number of hours to advance (between 0 and 23)
     * @param minute The number of minutes to advance (between 0 and 59)
     * @return A new {@link MinecraftDayTime}
     * @throws IllegalArgumentException if any of the arguments are negative.
     */
    MinecraftDayTime minus(int days, int hour, int minute);

    /**
     * Returns a {@link Duration} that represents in-game time from the
     * minecraft epoch (so, for Day 2 at 12:30pm will return a duration of
     * 1 day, 6 hours and 30 minutes).
     *
     * @return A {@link Duration}
     */
    Duration asInGameDuration();

    /**
     * Returns a {@link Duration} that represents wall-clock time from the
     * minecraft epoch (so, for Day 2 at 12:30pm will return a duration of
     * 25 minutes and 25 seconds for a vanilla minecraft server).
     *
     * @return A {@link Duration}
     */
    default Duration asWallClockDuration() {
        return this.asTicks().getExpectedDuration();
    }

    /**
     * Returns the number of {@link Ticks} that have elapsed since the minecraft
     * epoch.
     *
     * @return The epoch.
     */
    Ticks asTicks();

    /**
     * Creates {@link MinecraftDayTime} objects.
     */
    interface Factory {

        /**
         * @see MinecraftDayTime#ofInGameDuration(Duration)
         */
        MinecraftDayTime of(Duration duration);

        /**
         * @see MinecraftDayTime#of(int, int, int)
         */
        MinecraftDayTime of(int days, int hours, int minutes);

        /**
         * @see MinecraftDayTime#of(Ticks)
         */
        MinecraftDayTime of(Ticks ticks);

    }

}
