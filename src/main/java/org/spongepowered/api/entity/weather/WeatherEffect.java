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
package org.spongepowered.api.entity.weather;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;

import java.time.Duration;

/**
 * Represents weather, such as {@link LightningBolt}.
 */
public interface WeatherEffect extends Entity {

    /**
     * Returns whether this weather effect is an effect and doesn't deal damage.
     *
     * @return Whether this weather effect is an effect
     */
    default boolean isEffect() {
        return require(Keys.IS_WEATHER_EFFECT);
    }

    /**
     * Sets whether this weather effect is an effect and doesn't deal damage.
     *
     * @param effect Whether this weather effect is an effect
     */
    default void setEffect(boolean effect) {
        offer(Keys.IS_WEATHER_EFFECT, effect);
    }

    /**
     * Gets the {@link org.spongepowered.api.data.value.Value.Mutable} for the duration
     *
     * @return The bounded value for the remaining duration
     */
    default Value.Mutable<Duration> expireDuration() {
        return getValue(Keys.EXPIRATION_DURATION).get().asMutable();
    }

}
