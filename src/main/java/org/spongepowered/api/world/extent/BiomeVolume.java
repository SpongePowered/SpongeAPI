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

package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.biome.BiomeType;

/**
 * A volume containing biomes.
 */
public interface BiomeVolume {

    /**
     * Get an object representing the biome at the given position.
     *
     * <p>While {@code position} is a 3-dimensional position, biomes in
     * Minecraft are column-based (over the X and Z plane). Therefore, the biome
     * for all the blocks in a certain column will all be the same and changing
     * the biome of one block in a column will change the biome for the
     * entire column.</p>
     *
     * @param position The position
     * @return The biome
     */
    BiomeType getBiome(Vector3i position);

    /**
     * Sets the biome at the given position in the world.
     *
     * <p>While {@code position} is a 3-dimensional position, biomes in
     * Minecraft are column-based (over the X and Z plane). Therefore, the biome
     * for all the blocks in a certain column will all be the same and changing
     * the biome of one block in a column will change the biome for the
     * entire column.</p>
     *
     * @param position The position
     * @param biome The biome
     */
    void setBiome(Vector3i position, BiomeType biome);

}
