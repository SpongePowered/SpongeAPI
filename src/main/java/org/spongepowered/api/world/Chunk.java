/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.world;

import org.spongepowered.api.block.Block;

/**
 * Chunks are 16x256x16 (x/y/z) containers of {@link org.spongepowered.api.block.Block}s
 * in a specific {@link World}. Chunks use chunk coordinates, which
 * are simply block coordinates divided by 16 (one chunk every 16 blocks).
 */
public interface Chunk {

    /**
     * Gets the x chunk coordinate of this chunk as it appears in the
     * {@link World}.
     *
     * @return X chunk coordinate
     */
    int getX();

    /**
     * Gets the z chunk coordinate of this chunk as it appears in the
     * {@link World}.
     *
     * @return Z chunk coordinate
     */
    int getZ();

    /**
     * Gets the {@link org.spongepowered.api.block.Block} at the block coordinate x/y/z.
     *
     * @param x X block coordinate
     * @param y Y block coordinate
     * @param z Z block coordinate
     * @return The block
     * @throws IllegalArgumentException If coordinates given are outside the chunk's bounds
     */
    Block getBlock(int x, int y, int z);

    /**
     * Gets the {@link org.spongepowered.api.world.Voxel} at the block coordinate x/y/z.
     *
     * @param x X block coordinate
     * @param y Y block coordinate
     * @param z Z block coordinate
     * @return The voxel
     * @throws IllegalArgumentException If coordinates given are outside the chunk's bounds
     */
    Voxel getVoxel(int x, int y, int z);
}
