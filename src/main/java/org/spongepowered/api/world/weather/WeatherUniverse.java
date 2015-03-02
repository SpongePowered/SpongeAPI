/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.world.weather;

/**
 * A universe affected by {@link Weather}.
 */
public interface WeatherUniverse {

    /**
     * Gets the current {@link Weather} in this volume.
     *
     * @return The current weather.
     */
    Weather getWeather();

    /**
     * Gets the remaining duration of the current {@link Weather}.
     *
     * @return The remaining weather duration.
     */
    long getRemainingDuration();

    /**
     * Gets the duration the current {@link Weather} has been running for.
     *
     * @return The running weather duration.
     */
    long getRunningDuration();

    /**
     * Sets the {@link Weather} of the volume with a random duration.
     *
     * @param weather The new {@link Weather}.
     */
    void forecast(Weather weather);

    /**
     * Sets the {@link Weather} of the volume with the specified duration.
     *
     * @param weather The new {@link Weather}.
     * @param duration The specified duration.
     */
    void forecast(Weather weather, long duration);
}
