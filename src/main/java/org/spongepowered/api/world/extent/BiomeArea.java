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

import com.flowpowered.math.vector.Vector2i;

import org.spongepowered.api.world.biome.BiomeType;

/**
 * An area containing biomes.
 */
public interface BiomeArea {

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

    /**
     * Sets the biome at the given position in the world.
     *
     * @param position The position
     * @param biome The biome
     */
    void setBiome(Vector2i position, BiomeType biome);

    /**
     * Sets the biome at the given position in the world.
     *
     * @param x The X position
     * @param z The Z position
     * @param biome The biome
     */
    void setBiome(int x, int z, BiomeType biome);
}
