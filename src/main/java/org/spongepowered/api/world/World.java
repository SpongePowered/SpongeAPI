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
     * Gets a specific {@link Chunk} by its x/z chunk coordinate.
     *
     * @param x X chunk coordinate
     * @param z Z chunk coordinate
     * @return The chunk
     */
    Chunk getChunk(int x, int z);

    /**
     * Gets a specific {@link org.spongepowered.api.block.Block} by its x/y/z block coordinate.
     * @param x X block coordinate
     * @param y Y block coordinate
     * @param z Z block coordinate
     * @return The block
     */
    Block getBlock(int x, int y, int z);
}
