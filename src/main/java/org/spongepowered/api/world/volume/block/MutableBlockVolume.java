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
package org.spongepowered.api.world.volume.block;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.math.vector.Vector3i;

public interface MutableBlockVolume<M extends MutableBlockVolume<M>> extends StreamableBlockVolume<M>, MutableVolume {

    /**
     * Sets the block at the given position in the world.
     *
     * @param position The position
     * @param block The block
     * @return Whether the block change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    default boolean setBlock(Vector3i position, BlockState block) {
        return setBlock(position.getX(), position.getY(), position.getZ(), block);
    }

    /**
     * Sets the block at the given position in the world.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param block The block
     * @return Whether the block change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    boolean setBlock(int x, int y, int z, BlockState block);

    default boolean removeBlock(Vector3i position) {
        return removeBlock(position.getX(), position.getY(), position.getZ());
    }

    boolean removeBlock(int x, int y, int z);

}
