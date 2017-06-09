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
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.util.DiscreteTransform3;
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.extent.worker.BlockVolumeWorker;

/**
 * A volume containing blocks that can be at least accessed.
 */
public interface BlockVolume {

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
     * Gets the size of the whole volume. Defined as <code>
     * {@link #getBlockMax()} - {@link #getBlockMin()} + (1, 1, 1) </code>.
     *
     * @return The size
     */
    Vector3i getBlockSize();

    /**
     * Returns true if the block volume contains a block at the specified
     * position. This is defined as <code>{{@link #getBlockMin()} <= position <=
     * {@link #getBlockMax()}</code>
     *
     * @param position The position to check
     * @return Whether or not the position has a block in this volume
     */
    default boolean containsBlock(Vector3i position) {
        return containsBlock(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Returns true if the block volume contains a block at the specified
     * position. This is defined as <code>{{@link #getBlockMin()} <= (x, y, z)
     * <= {@link #getBlockMax()}</code>
     *
     * @param x The X coordinate to check
     * @param y The Y coordinate to check
     * @param z The Z coordinate to check
     * @return Whether or not the position has a block in this volume
     */
    boolean containsBlock(int x, int y, int z);

    /**
     * Gets a representation of the block at the given position.
     *
     * @param position The position
     * @return The block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    default BlockState getBlock(Vector3i position) {
        return getBlock(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets a representation of the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    BlockState getBlock(int x, int y, int z);

    /**
     * Gets the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @param position The position of the block
     * @return The type of block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the block volume
     */
    default BlockType getBlockType(Vector3i position) {
        return getBlockType(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The type of block
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the block volume
     */
    BlockType getBlockType(int x, int y, int z);

    /**
     * Returns a new volume that is the same or smaller than the current volume.
     * This does not copy the blocks, it only provides a new view of the
     * storage.
     *
     * @param newMin The new minimum coordinates in this volume
     * @param newMax The new maximum coordinates in this volume
     * @return The new volume with the new bounds
     * @throws PositionOutOfBoundsException If the new minimum and maximum are
     *         outside the current volume
     */
    BlockVolume getBlockView(Vector3i newMin, Vector3i newMax);

    /**
     * Returns a new volume that is viewed through some transformation. This
     * does not copy the blocks, it only provides a new view of the storage.
     *
     * @param transform The transformation to be applied
     * @return The new volume with the transform
     */
    BlockVolume getBlockView(DiscreteTransform3 transform);

    /**
     * Returns a new volume that is translated so that
     * {@link BlockVolume#getBlockMin()} returns {@link Vector3i#ZERO}. This
     * does not copy the blocks, it only provides a new view of the storage.
     *
     * @return The new volume with its minimum at zero
     */
    default BlockVolume getRelativeBlockView() {
        return getBlockView(DiscreteTransform3.fromTranslation(getBlockMin().negate()));
    }

    /**
     * Returns a new volume that cannot be modified through this view. Unlike
     * immutable storage, it can be changed by holders of mutable views. This
     * does not copy the blocks, it only provides a new view of the storage.
     *
     * @return The new volume, which cannot be modified
     */
    UnmodifiableBlockVolume getUnmodifiableBlockView();

    /**
     * Returns a mutable copy of the blocks stored in this volume. This uses the
     * default storage type of {@link StorageType#STANDARD}.
     *
     * @return A copy of the blocks
     */
    default MutableBlockVolume getBlockCopy() {
        return getBlockCopy(StorageType.STANDARD);
    }

    /**
     * Returns a mutable copy of the blocks stored in this volume. This uses the
     * provided storage type.
     *
     * @param type The type of storage used by the new blocks
     * @return A copy of the blocks
     */
    MutableBlockVolume getBlockCopy(StorageType type);

    /**
     * Returns an immutable copy of the blocks stored in this volume. This uses
     * some internal storage solution that is thread-safe by nature.
     *
     * @return An immutable copy of the blocks
     */
    ImmutableBlockVolume getImmutableBlockCopy();

    /**
     * Gets a new block worker for this block volume.
     *
     * @param cause The cause for the block worker to use for changes
     * @return The block worker
     */
    BlockVolumeWorker<? extends BlockVolume> getBlockWorker();

}
