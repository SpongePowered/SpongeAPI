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

import java.util.UUID;

/**
 * A loaded Minecraft world
 */
public interface World {

    /**
     * Gets the unique id ({@link java.util.UUID} for this world.
     *
     * @return The unique id or UUID
     */
    UUID getUniqueID();

    /**
     * Gets the name of the world.
     *
     * @return The world name
     */
    String getName();

    /**
     * Gets an already-loaded {@link Chunk} by its x/z chunk coordinate, or
     * null if it's not available
     *
     * @param cx X chunk coordinate
     * @param cz Z chunk coordinate
     * @return The chunk
     */
    Chunk getChunk(int cx, int cz);

    /**
     * Loads and returns a {@link Chunk}. If the chunk does not
     * exist, it will be generated unless `shouldGenerate` is false.
     *
     * @param cx             X chunk coordinate
     * @param cz             Z chunk coordinate
     * @param shouldGenerate Generate if new
     * @return Chunk loaded/generated
     */
    Chunk loadChunk(int cx, int cz, boolean shouldGenerate);

    /**
     * Gets a specific {@link org.spongepowered.api.block.Block} by its x/y/z block coordinate.
     *
     * @param x X block coordinate
     * @param y Y block coordinate
     * @param z Z block coordinate
     * @return The block
     */
    Block getBlock(int x, int y, int z);

    /**
     * Gets a specific {@link org.spongepowered.api.world.Voxel} by its x/y/z block coordinate.
     *
     * @param x X block coordinate
     * @param y Y block coordinate
     * @param z Z block coordinate
     * @return The voxel
     */
    Voxel getVoxel(int x, int y, int z);
}
