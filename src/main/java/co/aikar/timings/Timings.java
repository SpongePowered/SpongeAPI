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

import net.kyori.adventure.audience.Audience;
import org.spongepowered.api.Sponge;
import org.spongepowered.plugin.PluginContainer;

import java.util.Objects;

/**
 * Utility class for creating and configuring timings.
 */
public final class Timings {

    private Timings() {
    }

    /**
     * Gets a {@link Timing} for a plugin corresponding to a name.
     *
     * @param plugin The plugin instance to own the timing
     * @param name Name of the timing
     * @return A {@link Timing} instance
     */
    public static Timing of(final PluginContainer plugin, final String name) {
        Objects.requireNonNull(plugin, "PluginContainer cannot be null!");
        Objects.requireNonNull(name, "Timing name cannot be null!");
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).of(plugin, name, null);
    }

    /**
     * Gets a handler that has a groupHandler timer handler. Parent timers
     * should not have their start/stop methods called directly, as the children
     * will call it for you.
     * <p>Parent timers are used to group multiple
     * subsections together and get a summary of them combined parent handler
     * can not be changed after first call.</p>
     *
     * @param plugin The plugin instance to own the timing
     * @param name Name of the timing
     * @param groupHandler Parent handler to mirror .start/stop calls to
     * @return A {@link Timing} instance
     */
    public static Timing of(final PluginContainer plugin, final String name, final Timing groupHandler) {
        Objects.requireNonNull(plugin, "PluginContainer cannot be null!");
        Objects.requireNonNull(name, "Timing name cannot be null!");
        Objects.requireNonNull(groupHandler, "Group Handler cannot be null!");
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).of(plugin, name, groupHandler);
    }

    /**
     * Returns a {@link Timing} object after starting it, useful for
     * try-with-resources.
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
    public static Timing ofStart(final PluginContainer plugin, final String name) {
        final Timing timing = Timings.of(plugin, name);
        timing.startTimingIfSync();
        return timing;
    }

    /**
     * Returns a {@link Timing} object after starting it, useful for
     * try-with-resources.
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
    public static Timing ofStart(final PluginContainer plugin, final String name, final Timing groupHandler) {
        Objects.requireNonNull(plugin, "PluginContainer cannot be null!");
        Objects.requireNonNull(name, "Timing name cannot be null!");
        Objects.requireNonNull(groupHandler, "Group Handler cannot be null!");
        final Timing timing = Timings.of(plugin, name, groupHandler);
        timing.startTimingIfSync();
        return timing;
    }

    /**
     * Gets whether or not the timings system is enabled.
     *
     * @return Enabled or not
     */
    public static boolean isTimingsEnabled() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).isTimingsEnabled();
    }

    /**
     * Sets whether or not the timings system should be enabled. Calling
     * this will reset timing data.
     *
     * @param enabled Should timings be reported
     */
    public static void setTimingsEnabled(final boolean enabled) {
        Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).setTimingsEnabled(enabled);
    }

    /**
     * Gets whether or not the verbose level of timings is enabled. When
     * verbose is disabled, high-frequency timings will not be available.
     *
     * @return Enabled or not
     */
    public static boolean isVerboseTimingsEnabled() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).isVerboseTimingsEnabled();
    }

    /**
     * Sets whether or not the timings should monitor at verbose level.
     * When verbose is disabled, high-frequency timings will not be available.
     * Calling this will reset timing data.
     *
     * @param enabled Should high-frequency timings be reported
     */
    public static void setVerboseTimingsEnabled(final boolean enabled) {
        Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).setVerboseTimingsEnabled(enabled);
    }

    /**
     * Gets the interval between timing history report generation.
     *
     * @return Interval in ticks
     */
    public static int getHistoryInterval() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).getHistoryInterval();
    }

    /**
     * Sets the interval between timing history report generations.
     *
     * <p>This will re-check your history length, so lowering this value will
     * lower your history length if you need more than 60 history windows.</p>
     *
     * @param interval Interval in ticks
     */
    public static void setHistoryInterval(final int interval) {
        Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).setHistoryInterval(interval);
    }

    /**
     * Gets how long in ticks timings history is kept for the server.
     *
     * @return Duration in ticks
     */
    public static int getHistoryLength() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).getHistoryLength();
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
    public static void setHistoryLength(final int length) {
        Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).setHistoryLength(length);
    }

    /**
     * Resets all timing data.
     */
    public static void reset() {
        Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).reset();
    }

    /**
     * Generates a report and sends it to the specified
     * {@link Audience}.
     *
     * @param channel The channel to send report to
     */
    public static void generateReport(final Audience channel) {
        Sponge.getRegistry().getFactoryRegistry().provideFactory(TimingsFactory.class).generateReport(channel);
    }

}
