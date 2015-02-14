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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.util.gen.BlockBuffer;
import org.spongepowered.api.util.gen.MutableBlockBuffer;
import org.spongepowered.api.world.World;

/**
 * Represents a generator for chunks into a world.
 */
public interface WorldGenerator {

    /**
     * Generates the chunk at the given position in the world. The position
     * specified is the chunk position (ie. the world position divided by the
     * chunk size). The newly generated chunk should be placed into the given
     * {@link BlockBuffer}.
     *
     * @param world The world
     * @param buffer The buffer to generate the region into
     * @param position The chunk position
     */
    void generateChunk(World world, MutableBlockBuffer buffer, Vector3i position);

    /**
     * Gets whether map features are enabled and if this generator will be
     * creating structures (such as villages and strongholds etc.)
     *
     * @return Map features enabled
     */
    boolean areMapFeaturesEnabled();

    /**
     * Gets an ordered collection of {@link Populator}s which are applied
     * globally.
     *
     * @return The populators
     */
    Iterable<Populator> getGlobalPopulators();

    /**
     * Inserts a new populator to this Biome's ordered collection of
     * populators. The new populator is inserted at the given index. If the
     * index is larger than the current amount of populators then the new
     * populator in inserted at the end of the collection.
     *
     * @param populator The new populator
     * @param index THe index to insert the populator at
     */
    void insertPopulator(Populator populator, int index);

    /**
     * Gets the {@link BiomeGenerator} for this world generator.
     *
     * @return The biome generator
     */
    BiomeGenerator getBiomeGenerator();

    /**
     * Sets the {@link BiomeGenerator} for this world generator.
     *
     * @param biomeManager The new biome generator
     */
    void setBiomeGenerator(BiomeGenerator biomeManager);

}
