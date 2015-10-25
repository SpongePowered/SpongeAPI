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
package co.aikar.timings;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.source.ConsoleSource;

import javax.annotation.Nullable;

public final class Timings {

    private static final TimingsFactory factory = null;

    private Timings() {
    }

    /**
     * Gets a {@link Timing} for a plugin corresponding to a name.
     *
     * @param plugin The plugin instance to own the timing
     * @param name Name of the timing
     * @return A {@link Timing} instance
     */
    public static Timing of(Object plugin, String name) {
        return factory.of(checkNotNull(plugin, "plugin"), checkNotNull(name, "name"), null);
    }

    /**
     * Gets a handler that has a groupHandler timer handler. Parent timers
     * should not have their start/stop methods called directly, as the children
     * will call it for you. <p/> Parent Timers are used to group multiple
     * subsections togethers and get a summary of them combined Parent Handler
     * can not be changed after first call
     *
     * @param plugin The plugin instance to own the timing
     * @param name Name of the timing
     * @param groupHandler Parent handler to mirror .start/stop calls to
     * @return A {@link Timing} instance
     */
    public static Timing of(Object plugin, String name, Timing groupHandler) {
        return factory.of(checkNotNull(plugin, "plugin"), checkNotNull(name, "name"), checkNotNull(groupHandler, "groupHandler"));
    }

    /**
     * Returns a Timing object after starting it, useful for Java7
     * try-with-resources.</p>
     *
     * <code> try (Timing ignored = Timings.ofStart(plugin, someName)) { //
     * timed section } </code>
     *
     * @param plugin Plugin to own the Timing
     * @param name Name of Timing
     * @return Timing Handler
     */
    public static Timing ofStart(Object plugin, String name) {
        return factory.ofStart(checkNotNull(plugin, "plugin"), checkNotNull(name, "name"), null);
    }

    /**
     * Returns a Timing object after starting it, useful for Java7
     * try-with-resources.</p>
     *
     * <code> try (Timing ignored = Timings.ofStart(plugin, someName,
     * groupHandler)) { // timed section } </code>
     *
     * @param plugin Plugin to own the Timing
     * @param name Name of Timing
     * @param groupHandler Parent handler to mirror .start/stop calls to
     * @return Timing Handler
     */
    public static Timing ofStart(Object plugin, String name, Timing groupHandler) {
        return factory.ofStart(checkNotNull(plugin, "plugin"), checkNotNull(name, "name"), checkNotNull(groupHandler, "groupHandler"));
    }

    /**
     * Gets whether or not the Sponge Timings system is enabled
     *
     * @return Enabled or not
     */
    public static boolean isTimingsEnabled() {
        return factory.isTimingsEnabled();
    }

    /**
     * Sets whether or not the Spigot Timings system should be enabled <p/>
     * Calling this will reset timing data.
     *
     * @param enabled Should timings be reported
     */
    public static void setTimingsEnabled(boolean enabled) {
        factory.setTimingsEnabled(enabled);
    }

    /**
     * Gets whether or not the Verbose level of timings is enabled. <p/> When
     * Verbose is disabled, high-frequency timings will not be available
     *
     * @return Enabled or not
     */
    public static boolean isVerboseTimingsEnabled() {
        return factory.isVerboseTimingsEnabled();
    }

    /**
     * Sets whether or not the Timings should monitor at Verbose level. <p/>
     * When Verbose is disabled, high-frequency timings will not be available.
     * Calling this will reset timing data.
     *
     * @param enabled Should high-frequency timings be reported
     */
    public static void setVerboseTimingsEnabled(boolean enabled) {
        factory.setVerboseTimingsEnabled(enabled);
    }

    /**
     * Gets the interval between Timing History report generation. <p/> Defaults
     * to 5 minutes (6000 ticks)
     *
     * @return Interval in ticks
     */
    public static int getHistoryInterval() {
        return factory.getHistoryInterval();
    }

    /**
     * Sets the interval between Timing History report generations. <p/>
     * Defaults to 5 minutes (6000 ticks)
     *
     * This will recheck your history length, so lowering this value will lower
     * your history length if you need more than 60 history windows.
     *
     * @param interval Interval in ticks
     */
    public static void setHistoryInterval(int interval) {
        factory.setHistoryInterval(interval);
    }

    /**
     * Gets how long in ticks Timings history is kept for the server.
     *
     * Defaults to 1 hour (72000 ticks)
     *
     * @return Duration in Ticks
     */
    public static int getHistoryLength() {
        return factory.getHistoryLength();
    }

    /**
     * Sets how long Timing History reports are kept for the server.
     *
     * Defaults to 1 hours(72000 ticks)
     *
     * This value is capped at a maximum of getHistoryInterval() *
     * MAX_HISTORY_FRAMES (12)
     *
     * Will not reset Timing Data but may truncate old history if the new length
     * is less than old length.
     *
     * @param length Duration in ticks
     */
    public static void setHistoryLength(int length) {
        factory.setHistoryLength(length);
    }

    /**
     * Resets all Timing Data
     */
    public static void reset() {
        factory.reset();
    }

    /**
     * Generates a report and sends it to the specified command sender.
     *
     * If sender is null, {@link ConsoleSource} will be used.
     *
     * @param sender
     */
    public static void generateReport(@Nullable CommandSource sender) {
        factory.generateReport(sender);
    }

}
