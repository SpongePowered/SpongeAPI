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
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.Range;

import java.util.Optional;

/**
 * Attributes with which biomes are picked for during world generation.
 */
public interface BiomeAttributes {

    static BiomeAttributes point(final float temperature, final float humidity, final float continentalness, final float erosion, final float depth, final float weirdness, final float offset) {
        return Sponge.game().factoryProvider().provide(Factory.class).ofPoint(temperature, humidity, continentalness, erosion, depth, weirdness, offset);
    }

    static BiomeAttributes range(final Range<Float> temperature, final Range<Float> humidity, final Range<Float> continentalness, final Range<Float> erosion, final Range<Float> depth, final Range<Float> weirdness, final float offset) {
        return Sponge.game().factoryProvider().provide(Factory.class).ofRange(temperature, humidity, continentalness, erosion, depth, weirdness, offset);
    }

    static Optional<BiomeAttributes> defaultAttributes(RegistryReference<Biome> biome) {
        return Sponge.game().factoryProvider().provide(Factory.class).defaultAttributes(biome);
    }

    /**
     * The temperature range.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code -2} to {@code 2}.</p>
     *
     * @return temperature
     */
    Range<Float> temperature();

    /**
     * The humidity range.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code -2} to {@code 2}.</p>
     *
     * @return humidity
     */
    Range<Float> humidity();

    /**
     * The continentalness.
     * <p>Higher value when more inland. For low values oceans may generate.</p>
     *
     * @return continentalness
     */
    Range<Float> continentalness();

    /**
     * The erosion.
     * <p>Higher values result in flatter areas, low values result in mountainous areas.</p>
     *
     * @return erosion
     */
    Range<Float> erosion();

    /**
     * The depth.
     *
     * @return the depth.
     */
    Range<Float> depth();

    /**
     * Gets the weirdness.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code -2} to {@code 2}.</p>
     *
     * @return weirdness
     */
    Range<Float> weirdness();

    /**
     * The offset.
     *
     * <p>In Vanilla Minecraft, this is capped between {@code 0} to {@code 1}.</p>
     *
     * @return offset
     */
    float offset();

    interface Factory {

        /**
         * Returns the full range for {@link BiomeAttributes} settings.
         *
         * @return The full range
         */
        Range<Float> fullRange();

        /**
         * Creates {@link BiomeAttributes} with point values.
         *
         * @return A biome attributes point
         */
        BiomeAttributes ofPoint(float temperature, float humidity, float continentalness, float erosion, float depth, float weirdness, float offset);

        /**
         * Creates {@link BiomeAttributes} spanning a range of values.
         *
         * @return A biome attributes range
         */
        BiomeAttributes ofRange(Range<Float> temperature, Range<Float> humidity, Range<Float> continentalness, Range<Float> erosion, Range<Float> depth, Range<Float> weirdness, float offset);

        /**
         * Returns the default {@link BiomeAttributes} used in vanilla biomes.
         *
         * @param biome The biome attributes
         *
         * @return The biome attributes
         */
        Optional<BiomeAttributes> defaultAttributes(RegistryReference<Biome> biome);

    }
}
