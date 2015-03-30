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
package org.spongepowered.api.world.gen;

import java.util.List;

/**
 * Represents a generator for chunks into a world.
 */
public interface WorldGenerator {

    /**
     * Gets the {@link GeneratorPopulator} of this world generator.
     * @return The {@link GeneratorPopulator}.
     * @see #setGeneratorPopulator(GeneratorPopulator)
     */
    GeneratorPopulator getGeneratorPopulator();

    /**
     * Sets the {@link GeneratorPopulator} of this world generator.
     * @param generator The generator.
     */
    void setGeneratorPopulator(GeneratorPopulator generator);

    /**
     * Gets whether map features are enabled and if this generator will be
     * creating structures (such as villages and strongholds etc.)
     *
     * @return Map features enabled
     */
    boolean areMapFeaturesEnabled();

    /**
     * Gets an ordered, mutable list of {@link Populator}s which are applied
     * globally (in the whole world).
     *
     * @return The populators
     */
    List<Populator> getPopulators();

    /**
     * Gets the {@link BiomeGenerator} for this world generator.
     *
     * @return The biome generator
     */
    BiomeGenerator getBiomeGenerator();

    /**
     * Sets the {@link BiomeGenerator} for this world generator.
     *
     * @param biomeGenerator The new biome generator
     */
    void setBiomeGenerator(BiomeGenerator biomeGenerator);

    /**
     * Gets the random seed for this world. The world seed is used for terrain
     * generation.
     *
     * @return The seed
     */
    long getSeed();

    /**
     * Sets the random seed for this world.
     *
     * @param seed The seed
     */
    void setSeed(long seed);

}
