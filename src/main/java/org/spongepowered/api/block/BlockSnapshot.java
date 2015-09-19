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
package org.spongepowered.api.block;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.LocateableSnapshot;
import org.spongepowered.api.world.Location;

/**
 * An immutable representation of a {@link BlockState} and any extra data that
 * may be associated with it, including {@link TileEntity} related data..
 */
public interface BlockSnapshot extends LocateableSnapshot<BlockSnapshot> {

    /**
     * Gets the {@link BlockState}.
     *
     * @return The BlockState
     */
    BlockState getState();

    /**
     * Creates a copy of the {@link BlockSnapshot} with the provided 
     * {@link BlockState}. Any additional data associated with a
     * {@link TileEntity} or custom data may be lost.
     *
     * <p>Note: all custom data, including implementation detailed
     * data relating to any and all {@link TileEntity} instances that
     * was included in this snapshot will NOT copy over to the new
     * snapshot.</p>
     *
     * @param blockState The block state
     * @return The new snapshot
     */
    BlockSnapshot withState(BlockState blockState);

    /**
     * Creates a copy of the {@link BlockSnapshot} with the provided
     * {@link DataContainer}. Note that this is equal to calling
     * {@link BlockSnapshotBuilder#build(DataView)}. All data is
     * validated and
     *
     * @param container The data container
     * @return The new snapshot
     */
    BlockSnapshot withContainer(DataContainer container);

    /**
     * Restores the {@link BlockSnapshot} to the {@link Location} stored within
     * the snapshot. If the {@link Location} is not available, the snapshot will
     * not be restored.
     *
     * <p>If forced, the state of the block will change its {@link BlockType}
     * to match that of the snapshot then set the state. However, if force is
     * set to false and the {@link BlockType}s does not match, false will be
     * returned.
     * If notifyNeighbors is true, neighboring blocks will be notified of
     * changes at the restored block location triggering physic updates.</p>
     *
     * @param force If true, forces block state to be set even if the
     *     {@link BlockType} does not match the snapshot one.
     * @param notifyNeighbors If true, notifies neighboring blocks to update
     *     physics
     * @return true if the restore was successful, false otherwise
     */
    boolean restore(boolean force, boolean notifyNeighbors);
}
