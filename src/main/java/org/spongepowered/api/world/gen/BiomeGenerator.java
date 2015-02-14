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

import org.spongepowered.api.util.gen.MutableBiomeArea;
import org.spongepowered.api.world.World;

/**
 * Manages the biome generation for an extent.
 */
public interface BiomeGenerator {

    /**
     * Generates the biomes for the given area using only biomes from the given
     * array of available biomes. The resultant biomes are placed into the
     * given buffer.
     *
     * @param world The world these biomes are being generated for
     * @param buffer The buffer to generate the biomes into
     * @param x The X position of the lowest point
     * @param z The Z position of the lowest point
     * @param width The width of the area (X-axis size)
     * @param length The length of the area (Z-axis size)
     */
    void getBiomesForArea(World world, MutableBiomeArea buffer, int x, int z, int width, int length);

}
