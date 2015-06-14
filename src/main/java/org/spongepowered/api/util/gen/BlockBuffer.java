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
package org.spongepowered.api.util.gen;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;

/**
 * An buffer for {@link BlockType} data. This buffer has no direct relation
 * to the world and changes to it are not synchronized to the world.
 */
public interface BlockBuffer {

    /**
     * Gets the block location with the lowest x, y and z that is still a valid
     * position for {@link #getBlock(Vector3i)}.
     *
     * @return The lowest block location
     */
    Vector3i getBlockMin();

    /**
     * Gets the block location with the highest x, y and z that is still a valid
     * position for {@link #getBlock(Vector3i)}.
     *
     * @return The highest block location
     */
    Vector3i getBlockMax();

    /**
     * Gets the size of the whole volume. Defined as <code>{@link #getBlockMax()} -
     * {@link #getBlockMin()} + (1, 1, 1)</code>.
     *
     * @return The size
     */
    Vector3i getBlockSize();

    /**
     * Gets the block in the buffer at the given position.
     *
     * @param position The position.
     * @return The block
     */
    BlockState getBlock(Vector3i position);

    /**
     * Gets the block in the buffer at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The block
     */
    BlockState getBlock(int x, int y, int z);

}
