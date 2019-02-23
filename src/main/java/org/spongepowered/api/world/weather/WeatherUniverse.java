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
package org.spongepowered.api.world.weather;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.biome.BiomeTypes;

import java.time.Duration;

/**
 * A universe affected by {@link Weather}.
 */
public interface WeatherUniverse {

    /**
     * Gets the remaining {@link Duration} of the current
     * global {@link Weather}.
     *
     * @return The remaining global weather duration
     */
    Duration getRemainingGlobalWeatherDuration();

    /**
     * Gets the {@link Duration} the current global
     * {@link Weather} has been running for.
     *
     * @return The running global weather duration
     */
    Duration getGlobalWeatherDuration();

    /**
     * Gets the {@link Weather} at the given position.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return The weather at the position
     */
    Weather getWeather(int x, int y, int z);

    /**
     * Gets the {@link Weather} at the given position.
     *
     * @param position The position
     * @return The weather at the position
     */
    default Weather getWeather(Vector3i position) {
        return getWeather(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets the current global {@link Weather} in this volume.
     *
     * @return The current global weather
     */
    Weather getGlobalWeather();

    /**
     * Sets the global {@link Weather} of the volume with a random duration.
     *
     * <p>Setting a global weather affects the volume depending on
     * the biomes and possible other factors. For example, in the
     * {@link BiomeTypes#DESERT} it's never possible to rain/snow.</p>
     *
     * @param weather The weather that should be switched to globally
     */
    void setGlobalWeather(Weather weather);

    /**
     * Sets the global {@link Weather} of the world with the specified duration.
     *
     * <p>Setting a global weather affects the volume depending on
     * the biomes and possible other factors. For example, in the
     * {@link BiomeTypes#DESERT} it's never possible to rain/snow.</p>
     *
     * @param weather The weather that should be switched to globally
     * @param duration The specified duration
     */
    void setGlobalWeather(Weather weather, Duration duration);
}
