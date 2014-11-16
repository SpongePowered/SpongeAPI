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

package org.spongepowered.api.event.weather;

import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.WeatherType;

/**
 * Called when a world's weather changes
 */
public interface WeatherChangeEvent extends WeatherEvent {

    /**
     * Gets the {@link Weather} that was happening before this event.
     *
     * @return The {@link Weather} before the event was called
     */
    Weather getInitialWeather();

    /**
     * Gets the {@link Weather} that this event is creating.
     *
     * @return The {@link Weather} after this event is called
     */
    Weather getResultingWeather();

    /**
     * Sets what the new {@link Weather} should be with a random duration.
     *
     * @param weather The new {@link Weather}
     */
    void setResultingWeather(Weather weather);

    /**
     * Sets what the new {@link WeatherType} should be with a given duration.
     *
     * @param weather The new {@link Weather}
     * @param duration The duration of the weather in seconds
     */
    void setResultingWeather(Weather weather, int duration);

}
