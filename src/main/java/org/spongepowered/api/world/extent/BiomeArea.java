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
package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.biome.BiomeType;

/**
 * An area containing biomes.
 *
 * <p>Some methods accept a pair of two ints, representing the x and z location
 * of a biome. Some other methods accept or return a {@link Vector2i}. The
 * y position of this vector is equal to the z position of a biome in the
 * world.</p>
 */
public interface BiomeArea {

    /**
     * Gets the biome location with the lowest x and y that is still a valid
     * position for {@link #getBiome(Vector2i)}.
     *
     * @return The lowest biome location
     */
    Vector2i getBiomeMin();

    /**
     * Gets the biome location with the highest x and y that is still a valid
     * position for {@link #getBiome(Vector2i)}.
     *
     * @return The highest biome location.
     */
    Vector2i getBiomeMax();

    /**
     * Gets the size of the area. Defined as <code>{@link #getBiomeMax()} -
     * {@link #getBiomeMin()} + (1, 1)</code>.
     *
     * @return The size
     */
    Vector2i getBiomeSize();

    /**
     * Returns true if the biome area contains a biome at the specified
     * position. This is defined as <code>{{@link #getBiomeMin()} <=
     * position <= {@link #getBiomeMax()}</code>
     *
     * @param position The position to check
     * @return Whether or not the position has a biome in this area
     */
    boolean containsBiome(Vector2i position);

    /**
     * Returns true if the biome area contains a biome at the specified
     * position. This is defined as <code>{{@link #getBiomeMin()} <=
     * (x, z) <= {@link #getBiomeMax()}</code>
     *
     * @param x The X coordinate to check
     * @param z The Z coordinate to check
     * @return Whether or not the position has a biome in this area
     */
    boolean containsBiome(int x, int z);

    /**
     * Get an object representing the biome at the given position.
     *
     * @param position The position
     * @return The biome
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the area
     */
    BiomeType getBiome(Vector2i position);

    /**
     * Gets the {@link BiomeType} at the given location.
     *
     * @param x The X position
     * @param z The Z position
     * @return The biome
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the area
     */
    BiomeType getBiome(int x, int z);

    /**
     * Sets the biome at the given position in the world.
     *
     * @param position The position
     * @param biome The biome
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the area
     */
    void setBiome(Vector2i position, BiomeType biome);

    /**
     * Sets the biome at the given position in the world.
     *
     * @param x The X position
     * @param z The Z position
     * @param biome The biome
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the area
     */
    void setBiome(int x, int z, BiomeType biome);
}
