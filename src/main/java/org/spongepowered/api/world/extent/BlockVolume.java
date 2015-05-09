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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.PositionOutOfBoundsException;

/**
 * A volume containing blocks.
 */
public interface BlockVolume {

    /**
     * Gets the block location with the lowest x, y and z that is still a
     * valid position for {@link #getBlock(Vector3i)}.
     *
     * @return The lowest block location
     */
    Vector3i getBlockMin();

    /**
     * Gets the block location with the highest x, y and z that is still a
     * valid position for {@link #getBlock(Vector3i)}.
     *
     * @return The highest block location
     */
    Vector3i getBlockMax();

    /**
     * Gets the size of the whole volume. Defined as <code>
     *     {@link #getBlockMax()} - {@link #getBlockMin()} + (1, 1, 1)
     * </code>.
     *
     * @return The size
     */
    Vector3i getBlockSize();

    /**
     * Returns true if the block volume contains a block at the specified
     * position. This is defined as <code>{{@link #getBlockMin()} <=
     * position <= {@link #getBlockMax()}</code>
     *
     * @param position The position to check
     * @return Whether or not the position has a block in this volume
     */
    boolean containsBlock(Vector3i position);

    /**
     * Returns true if the block volume contains a block at the specified
     * position. This is defined as <code>{{@link #getBlockMin()} <=
     * (x, y, z) <= {@link #getBlockMax()}</code>
     *
     * @param x The X coordinate to check
     * @param y The Y coordinate to check
     * @param z The Z coordinate to check
     * @return Whether or not the position has a block in this volume
     */
    boolean containsBlock(int x, int y, int z);

    /**
     * Get a representation of the block at the given position.
     *
     * @param position The position
     * @return The block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the volume
     */
    BlockState getBlock(Vector3i position);

    /**
     * Get a representation of the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the volume
     */
    BlockState getBlock(int x, int y, int z);

    /**
     * Sets the block at the given position in the world.
     *
     * @param position The position
     * @param block The block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the volume
     */
    void setBlock(Vector3i position, BlockState block);

    /**
     * Sets the block at the given position in the world.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param block The block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *     bounds of the volume
     */
    void setBlock(int x, int y, int z, BlockState block);

}
