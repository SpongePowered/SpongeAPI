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
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.plugin.PluginContainer;

/**
 * A factory for the required implementation of {@link Timings}.
 */
public interface TimingsFactory {

    /**
     * Gets or creates a timing instance for the plugin with the given name.
     *
     * @param plugin Plugin owning the timing
     * @param name Name of the timing
     * @param groupHandler The handler, can be null for no parent
     * @return A timing instance
     */
    Timing of(PluginContainer plugin, String name, @Nullable Timing groupHandler);

    /**
     * Gets whether the timing system is enabled.
     *
     * @return Whether enabled
     */
    boolean isTimingsEnabled();

    /**
     * Sets whether the timing system is enabled.
     *
     * @param enabled Is enabled or not
     */
    void setTimingsEnabled(boolean enabled);

    /**
     * Gets whether verbose mode is enabled.
     *
     * @return Whether verbose mode is enabled
     */
    boolean isVerboseTimingsEnabled();

    /**
     * Sets whether verbose mode is enabled.
     *
     * @param enabled Is enabled
     */
    void setVerboseTimingsEnabled(boolean enabled);

    /**
     * Gets the history interval.
     *
     * @return The history interval in ticks
     */
    int getHistoryInterval();

    /**
     * Sets the history interval.
     *
     * @param interval The interval in ticks
     */
    void setHistoryInterval(int interval);

    /**
     * Gets the history length.
     *
     * @return History length
     */
    int getHistoryLength();

    /**
     * Sets the history length.
     *
     * @param length History length
     */
    void setHistoryLength(int length);

    /**
     * Resets the timing data.
     */
    void reset();

    /**
     * Generates a report and sends to the given channel.
     *
     * @param channel Channel to send to
     */
    void generateReport(Audience channel);
}
