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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.util.Ticks;

import java.util.function.Supplier;

public interface Weather extends DataSerializable {

    /**
     * Gets the {@link WeatherType type}.
     *
     * @return The type
     */
    WeatherType type();

    /**
     * Gets the remaining {@link Ticks} of this weather.
     *
     * @return The remaining duration
     */
    Ticks remainingDuration();

    /**
     * Gets the number of {@link Ticks} that the weather has ran for.
     *
     * @return The running duration
     */
    Ticks runningDuration();

    /**
     * Creates a new weather with given type, remaining duration and no running duration
     *
     * @param type The weather type
     * @param duration The weather remaining duration
     *
     * @return The new weather
     */
    static Weather of(Supplier<WeatherType> type, long duration) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(type.get(), Ticks.of(duration), Ticks.of(0));
    }

    /**
     * Creates a new weather with given type, remaining duration and no running duration
     *
     * @param type The weather type
     * @param duration The weather remaining duration
     *
     * @return The new weather
     * @throws IllegalArgumentException if the duration is infinite
     */
    static Weather of(Supplier<WeatherType> type, Ticks duration) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(type.get(), duration, Ticks.of(0));
    }

    /**
     * Creates a new weather with given type, remaining duration and no running duration
     *
     * @param type The weather type
     * @param duration The weather remaining duration
     *
     * @return The new weather
     */
    static Weather of(WeatherType type, long duration) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(type, Ticks.of(duration), Ticks.of(0));
    }

    /**
     * Creates a new weather with given type, remaining duration and no running duration
     *
     * @param type The weather type
     * @param duration The weather remaining duration
     *
     * @return The new weather
     * @throws IllegalArgumentException if the duration is infinite
     */
    static Weather of(WeatherType type, Ticks duration) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(type, duration, Ticks.of(0));
    }

    interface Factory {
        Weather of(WeatherType type, Ticks remainingDuration, Ticks runningDuration);
    }
}
