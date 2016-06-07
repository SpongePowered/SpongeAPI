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
package org.spongepowered.api.event.world;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.WeatherUniverse;

/**
 * Called when a {@link WeatherUniverse}'s {@link Weather} changes.
 */
public interface ChangeWorldWeatherEvent extends TargetWorldEvent, Cancellable {

    /**
     * Gets the original {@link Weather} that the event is creating.
     * @return The original Weather
     */
    Weather getOriginalWeather();

    /**
     * Gets the {@link Weather} that was happening before this event.
     *
     * @return The Weather before the event was called
     */
    Weather getInitialWeather();

    /**
     * Gets the {@link Weather} that this event is creating.
     *
     * @return The Weather after this event is called
     */
    Weather getWeather();

    /**
     * Sets what the new {@link Weather} should be with a random duration.
     *
     * @param weather The new Weather
     */
    void setWeather(Weather weather);

    /**
     * Gets the original duration of {@link ChangeWorldWeatherEvent#getWeather()} that would run after event.
     * @return The original duration
     */
    int getOriginalDuration();

    /**
     * Sets the duration of the {@link Weather} (in ticks).
     *
     * @return The duration of the weather (in ticks)
     */
    int getDuration();

    /**
     * Sets the duration of the {@link Weather} (in ticks).
     *
     * @param duration The duration of the weather (in ticks)
     */
    void setDuration(int duration);
}
