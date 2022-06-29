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
package org.spongepowered.api.world.generation.config.noise;

/**
 * Noise Router for world generation.
 * See {@link NoiseGeneratorConfigs} {@link NoiseGeneratorConfig#noiseRouter()} for the default routers used by vanilla.
 */
public interface NoiseRouter {

    /**
     * Returns the density function for barrierNoise
     *
     * @return The density function
     */
    DensityFunction barrierNoise();

    /**
     * Returns the density function for fluidLevelFloodednessNoise
     *
     * @return The density function
     */
    DensityFunction fluidLevelFloodednessNoise();

    /**
     * Returns the density function for fluidLevelSpreadNoise
     *
     * @return The density function
     */
    DensityFunction fluidLevelSpreadNoise();

    /**
     * Returns the density function for lavaNoise
     *
     * @return The density function
     */
    DensityFunction lavaNoise();

    /**
     * Returns the density function for temperature
     *
     * @return The density function
     */
    DensityFunction temperature();

    /**
     * Returns the density function for vegetation
     *
     * @return The density function
     */
    DensityFunction vegetation();

    /**
     * Returns the density function for continents
     *
     * @return The density function
     */
    DensityFunction continents();

    /**
     * Returns the density function for erosion
     *
     * @return The density function
     */
    DensityFunction erosion();

    /**
     * Returns the density function for depth
     *
     * @return The density function
     */
    DensityFunction depth();

    /**
     * Returns the density function for ridges
     *
     * @return The density function
     */
    DensityFunction ridges();

    /**
     * Returns the density function for initialDensityWithoutJaggedness
     *
     * @return The density function
     */
    DensityFunction initialDensityWithoutJaggedness();

    /**
     * Returns the density function for finalDensity
     *
     * @return The density function
     */
    DensityFunction finalDensity();

    /**
     * Returns the density function for veinToggle
     *
     * @return The density function
     */
    DensityFunction veinToggle();

    /**
     * Returns the density function for veinRidged
     *
     * @return The density function
     */
    DensityFunction veinRidged();

    /**
     * Returns the density function for veinGap
     *
     * @return The density function
     */
    DensityFunction veinGap();

}
