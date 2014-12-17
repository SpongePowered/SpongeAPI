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

import org.spongepowered.api.world.biome.BiomeManager;
import org.spongepowered.api.world.extent.MutableBlockBuffer;

/**
 * A populator which acts directly on the {@link MutableBlockBuffer} during the
 * generation phase rather than the population phase.
 */
public interface GeneratorPopulator {

    /**
     * Performs the changes to the given {@link MutableBlockBuffer}.
     * 
     * <p>The given position is the lowest point of the buffer in order to
     * properly mutate the seed to ensure that all chunks are unique, while
     * at the same time the same chunk will always generate the same for a
     * given seed.</p>
     * 
     * @param buffer The buffer to apply the changes to
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param biomes The biomes for generation
     * @param seed The random seed
     */
    void populate(MutableBlockBuffer buffer, int x, int y, int z, BiomeManager biomes, long seed);

}
