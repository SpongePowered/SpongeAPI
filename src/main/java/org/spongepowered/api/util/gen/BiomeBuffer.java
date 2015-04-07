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
package org.spongepowered.api.util.gen;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.extent.BiomeArea;

/**
 * An buffer for {@link BiomeType} data. This buffer has no direct relation to
 * the world and changes to it are not synchronized to the world.
 *
 * <p>Unlike {@link BiomeArea}, buffers are guaranteed to be loaded in memory as
 * a whole. Calling methods like {@link #getBiome(Vector2i)} will never result
 * in new terrain being generated. As a result of this, biome buffers are much
 * more restricted in size than a {@link BiomeArea}.</p>
 */
public interface BiomeBuffer {

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
     * Get an object representing the biome at the given position.
     *
     * @param position The position
     * @return The biome
     */
    BiomeType getBiome(Vector2i position);

    /**
     * Gets the {@link BiomeType} at the given location.
     *
     * @param x The X position
     * @param z The Z position
     * @return The biome
     */
    BiomeType getBiome(int x, int z);

}
