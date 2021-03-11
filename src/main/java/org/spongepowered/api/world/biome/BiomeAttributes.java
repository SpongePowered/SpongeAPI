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
package org.spongepowered.api.world.biome;

import org.spongepowered.api.Sponge;

public interface BiomeAttributes {

    static BiomeAttributes of(final float temperature, final float humidity, final float altitude, final float weirdness, final float offset) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(temperature, humidity, altitude, weirdness, offset);
    }

    /**
     * Gets the temperature.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code -2} to {@code 2}.</p>
     * @return temperature
     */
    float temperature();

    /**
     * Get the humidity.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code -2} to {@code 2}.</p>
     * @return humidity
     */
    float humidity();

    /**
     * Gets the altitude.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code -2} to {@code 2}.</p>
     * @return altitude
     */
    float altitude();

    /**
     * Gets the weirdness.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code -2} to {@code 2}.</p>
     * @return weirdness
     */
    float weirdness();

    /**
     * Gets the offset.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code 0} to {@code 1}.</p>
     * @return offset
     */
    float offset();

    interface Factory {

        BiomeAttributes of(float temperature, float humidity, float altitude, float weirdness, float offset);
    }
}
