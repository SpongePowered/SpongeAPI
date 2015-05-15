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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.util.annotation.TransformWith;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

/**
 * A mutable complete representation of a block type and its associated data. Any changes made to the snapshot do not
 * reflect back on the block type and data that this snapshot came from.
 *
 * <p>A block snapshot contains block type, block properties (state), as
 * well as extra block data.</p>
 *
 * @see Location
 */
public interface BlockSnapshot extends DataSerializable {

    /**
     * Get the block state for this snapshot.
     *
     * @return The stored block state
     */
    BlockState getState();

    /**
     * Sets the {@link BlockState} for this {@link BlockSnapshot}.
     *
     * @param blockState The block state to set
     */
    void setBlockState(BlockState blockState);

    /**
     * Gets the {@link Vector3i} of this {@link BlockSnapshot}. The vector and
     * this snapshot may be out of sync with regards to actual data at the
     * vector, however, the {@link BlockState} remains immutable.
     *
     * @return The vector location of this snapshot
     */
    Vector3i getLocation();

    /**
     * Sets the {@link Vector3i} location of this {@link BlockSnapshot} that
     * can be applied to {@link Extent}s.
     *
     * @param location The vector location to set
     */
    void setLocation(Vector3i location);

    /**
     * Copies the snapshot.
     * @return The copied snapshot
     */
    @TransformWith
    BlockSnapshot copy();

}
