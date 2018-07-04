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

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import javax.annotation.Nullable;

/**
 * Utility class for creating and configuring timings.
 */
public final class Timings {

    private static final TimingsFactory factory = DummyObjectProvider.createFor(TimingsFactory.class, "factory");

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
     * will call it for you. <p/> Parent timers are used to group multiple
     * subsections together and get a summary of them combined parent handler
     * can not be changed after first call.
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
     * Returns a {@link Timing} object after starting it, useful for
     * try-with-resources.</p>
     *
     * <pre>
     * try (Timing ignored = Timings.ofStart(plugin, someName)) {
     *     // timed section
     * }
     * </pre>
     *
     * @param plugin Plugin to own the timing
     * @param name Name of timing
     * @return A {@link Timing} instance
     */
    public static Timing ofStart(Object plugin, String name) {
        Timing timing = of(plugin, name);
        timing.startTimingIfSync();
        return timing;
    }

    /**
     * Returns a {@link Timing} object after starting it, useful for
     * try-with-resources.</p>
     *
     * <pre>
     * try (Timing ignored = Timings.ofStart(plugin, someName,
     *         groupHandler)) {
     *     // timed section
     * }
     * </pre>
     *
     * @param plugin Plugin to own the timing
     * @param name Name of timing
     * @param groupHandler Parent handler to mirror start/stop calls to
     * @return A {@link Timing} instance
     */
    public static Timing ofStart(Object plugin, String name, Timing groupHandler) {
        Timing timing = of(plugin, name, groupHandler);
        timing.startTimingIfSync();
        return timing;
    }

    /**
     * Gets whether or not the timings system is enabled.
     *
     * @return Enabled or not
     */
    public static boolean isTimingsEnabled() {
        return factory.isTimingsEnabled();
    }

    /**
     * Sets whether or not the timings system should be enabled. <p/> Calling
     * this will reset timing data.
     *
     * @param enabled Should timings be reported
     */
    public static void setTimingsEnabled(boolean enabled) {
        factory.setTimingsEnabled(enabled);
    }

    /**
     * Gets whether or not the verbose level of timings is enabled. <p/> When
     * verbose is disabled, high-frequency timings will not be available.
     *
     * @return Enabled or not
     */
    public static boolean isVerboseTimingsEnabled() {
        return factory.isVerboseTimingsEnabled();
    }

    /**
     * Sets whether or not the timings should monitor at verbose level. <p/>
     * When verbose is disabled, high-frequency timings will not be available.
     * Calling this will reset timing data.
     *
     * @param enabled Should high-frequency timings be reported
     */
    public static void setVerboseTimingsEnabled(boolean enabled) {
        factory.setVerboseTimingsEnabled(enabled);
    }

    /**
     * Gets the interval between timing history report generation.
     *
     * @return Interval in ticks
     */
    public static int getHistoryInterval() {
        return factory.getHistoryInterval();
    }

    /**
     * Sets the interval between timing history report generations.
     *
     * <p>This will re-check your history length, so lowering this value will
     * lower your history length if you need more than 60 history windows.</p>
     *
     * @param interval Interval in ticks
     */
    public static void setHistoryInterval(int interval) {
        factory.setHistoryInterval(interval);
    }

    /**
     * Gets how long in ticks timings history is kept for the server.
     *
     * @return Duration in ticks
     */
    public static int getHistoryLength() {
        return factory.getHistoryLength();
    }

    /**
     * Sets how long timing history reports are kept for the server.
     *
     * <p>This value is capped at a maximum of getHistoryInterval() *
     * MAX_HISTORY_FRAMES (12).</p>
     *
     * <p>Will not reset timing data but may truncate old history if the new
     * length is less than old length.</p>
     *
     * @param length Duration in ticks
     */
    public static void setHistoryLength(int length) {
        factory.setHistoryLength(length);
    }

    /**
     * Resets all timing data.
     */
    public static void reset() {
        factory.reset();
    }

    /**
     * Generates a report and sends it to the specified command source.
     *
     * <p>If source is null, the {@link ConsoleSource} will be used.</p>
     *
     * @param source The source to show the report to
     */
    public static void generateReport(@Nullable CommandSource source) {
        factory.generateReport(source);
    }

    /**
     * Generates a report and sends it to the specified
     * {@link MessageChannel}.
     *
     * @param channel The channel to send report to
     */
    public static void generateReport(MessageChannel channel) {
        factory.generateReport(channel);
    }

}
